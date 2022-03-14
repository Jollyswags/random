class LFUCache {

    private final int capacity;
    private final Map<Integer, Integer> data; // Key -> Value
    private final Map<Integer, Integer> counters; // Key -> Counter
    private final Map<Integer, Set<Integer>> reverse; // Counter -> Set<Key>
    private int minCounter;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.data = new HashMap<>();
        this.counters = new HashMap<>();
        this.reverse = new HashMap<>();
    }
    
    public int get(int key) {
        Integer value = data.get(key);
        if (value == null) {
            return -1;
        }
        touch(key);
        return value;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (data.size() == capacity && !data.containsKey(key)) {
            evict();
        }
        data.put(key, value);
        touch(key);
    }
    
    private void touch(int key) {
        int keyCount = counters.compute(key, (k, v) -> (v == null) ? 1 : (v + 1));
        reverse.computeIfAbsent(keyCount, k -> new LinkedHashSet<>()).add(key);
        
        int prevCount = keyCount - 1;
        if (reverse.containsKey(prevCount)) {
            Set<Integer> prevKeySet = reverse.get(prevCount);
            prevKeySet.remove(key);
            if (prevKeySet.isEmpty()) {
                reverse.remove(prevCount);
                if (prevCount == minCounter) {
                    minCounter = keyCount;
                }
            }
        } else {
            minCounter = keyCount; // New key (i.e. keyCount = 1)
        }
    }
    
    private void evict() {
        Set<Integer> keySet = reverse.get(minCounter);
        int keyToEvict = keySet.iterator().next();
        data.remove(keyToEvict);
        counters.remove(keyToEvict);
        keySet.remove(keyToEvict);
        if (keySet.isEmpty()) {
            reverse.remove(minCounter);
        }
        // No need to change `minCounter` because `touch()` will set it to 1 later
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */