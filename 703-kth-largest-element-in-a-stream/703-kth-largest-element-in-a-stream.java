class KthLargest {
PriorityQueue<Integer> pq=new PriorityQueue<>();
    int l;
    public KthLargest(int k, int[] nums) {
        l=k;
        for(int i:nums)
            add(i);        
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size()>l)
            pq.remove();
        return pq.peek();
        
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */