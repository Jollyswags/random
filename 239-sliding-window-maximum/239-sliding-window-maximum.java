class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length, ind = 0;
        int[] res = new int[n - k + 1];
        
        for (int i = 0; i < n; i++) {
            // need to keep the queue in monotinically decreasing
            // keep a queue in decreasing order, as on the front(first) there must be maximum
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
                deque.pollLast();
            
            // add the number at last, which will be smaller then all previous number in the queue
            deque.addLast(i);
            
            // need to remove al the element fron the front which are NOT part of window
            // that's why we are using index
            while (!deque.isEmpty() && (i - deque.peekFirst()) >= k)
                deque.pollFirst();
            
            // update the res, once we have index >= k - 1, 
            // window of k, index will be k - 1 and greater
            if (i >= (k - 1))
                res[ind++] = nums[deque.peekFirst()];
        }
        return res;
    }
}
//n
//k