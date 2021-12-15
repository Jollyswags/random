class MKAverage {
    class Node {
        int val;
        int time;
        Node(int val, int time) {
            this.val = val;
            this.time = time;
        }
    }
    
    private TreeSet<Node> set; 
    private Deque<Node> queue;
    private Node kLeft;
    private Node kRight;
    
    int m;
    int k;
    
    int time;
    int sum;

    public MKAverage(int m, int k) {
        this.set = new TreeSet<>((a,b) -> (a.val != b.val) ? a.val - b.val : a.time - b.time);
        this.queue = new LinkedList<>();
        this.m = m;
        this.k = k;
        
        this.time = 0;
        this.sum = 0;
    }
    
    public void addElement(int num) {
        Node node = new Node(num, time++);

        addNode(node);
        removeNode();
        
        if (time == m) init();
    }
    
    private void init() {
        int i = 0;
        for (Node node : set) {
            if (i < k-1);
            else if (i == k-1) kLeft = node;
            else if (i < m-k) sum += node.val;
            else if (i == m-k) {
                kRight = node;
                return;
            }
            
            i++;
        }
        return;
    }
    
    private void addNode(Node node) {
        queue.offerLast(node);
        set.add(node);
        
        if (queue.size() <= m) return;
        
        if (node.val < kLeft.val) {
            sum += kLeft.val;
            kLeft = set.lower(kLeft);
        } else if (node.val >= kRight.val) {
            sum += kRight.val;
            kRight = set.higher(kRight);
        } else {
            sum += node.val;
        } 
    }
    
    private void removeNode() {
        if (queue.size() <= m) return;
        
        Node node = queue.pollFirst();
        
        if (node.val < kLeft.val || (node.val == kLeft.val && node.time <= kLeft.time)) {
            kLeft = set.higher(kLeft);
            sum -= kLeft.val;
        } else if (node.val > kRight.val || (node.val == kRight.val && node.time >= kRight.time)) {
            kRight = set.lower(kRight);
            sum -= kRight.val;
        } else {
            sum -= node.val;
        }
        
        set.remove(node);
    }
    
    public int calculateMKAverage() {
        return (queue.size() < m ? -1 : sum / (m - 2 * k));
    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */