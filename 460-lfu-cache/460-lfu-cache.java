class LFUCache {

    private final Node[] map = new Node[100001];
    private final Queue[] frequencyBuckets = new Queue[100001];
    private final int capacity;

    private int size;
    private int minBucket;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        var node = map[key];

        if (node == null) {
            return -1;
        }

        refreshBuckets(node);

        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        var node = map[key];

        if (node != null) {
            refreshBuckets(node);
            node.val = value;
        } else {
            ++size;
            removeLFU();
            map[key] = Node.of(key, value);

            minBucket = 1;

            initBucketIfNotPresent(minBucket);

            frequencyBuckets[minBucket].offer(map[key]);
        }
    }

    private void refreshBuckets(Node node) {
        var frequencyBucket = frequencyBuckets[node.frequency];
        frequencyBucket.remove(node);

        if (node.isFrequencyEqualTo(minBucket) && frequencyBucket.isEmpty()) {
            ++minBucket;
        }

        node.frequencyIncrement();

        initBucketIfNotPresent(node.frequency);

        frequencyBuckets[node.frequency].offer(node);
    }

    private void initBucketIfNotPresent(int frequency) {
        if (frequencyBuckets[frequency] == null) {
            frequencyBuckets[frequency] = new Queue();
        }
    }

    private void removeLFU() {
        if (size <= capacity) {
            return;
        }

        --size;
        var frequencyBucket = frequencyBuckets[minBucket];
        var node = frequencyBucket.poll();
        map[node.key] = null;
    }

    private static final class Queue {

        private final Node head = new Node(-1, -1);
        private final Node tail = new Node(-1, -1);

        public Queue() {
            this.head.next = this.tail;
            this.tail.prev = this.head;
        }

        // offer to head
        public void offer(Node node) {
            node.next = head.next;

            if (head.next != null) {
                head.next.prev = node;
            }

            head.next = node;
            node.prev = head;
        }

        // poll from tail
        public Node poll() {
            return doRemove(tail.prev);
        }

        public Node remove(Node node) {
            return doRemove(node);
        }

        private Node doRemove(Node node) {

            if (node == head || node == tail) {
                return null;
            }

            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;

            return node;
        }

        public boolean isEmpty() {
            return head.next == tail;
        }

    }

    private static final class Node {

        private final int key;
        private int val;
        private int frequency;

        private Node next;
        private Node prev;

        private Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.frequency = 1;
        }

        public static Node of(int key, int val) {
            return new Node(key, val);
        }

        public void frequencyIncrement() {
            ++this.frequency;
        }

        public boolean isFrequencyEqualTo(int frequency) {
            return this.frequency == frequency;
        }
    }
}
/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */