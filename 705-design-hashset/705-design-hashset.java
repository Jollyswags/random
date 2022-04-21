class MyHashSet {
    boolean[] hash;
    public MyHashSet() {
        hash = new boolean[1];
    }
    
    public void add(int key) {
        if(key > hash.length - 1){
            boolean[] newHash = new boolean[key + hash.length * 2];
            System.arraycopy(hash,0,newHash,0,hash.length);
            hash = newHash;
        }
        hash[key] = true;
    }
    
    public void remove(int key) {
        if(key > hash.length - 1)
            return;
        hash[key] = false;
    }
    
    public boolean contains(int key) {
        if(key > hash.length - 1)
            return false;
        return hash[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */