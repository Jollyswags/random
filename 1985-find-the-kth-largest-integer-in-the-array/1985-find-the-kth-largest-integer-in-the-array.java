class Solution {
    public String kthLargestNumber(String[] nums, int k) {
       Queue<String> queue = new PriorityQueue<>( (a, b) -> {
           if(a.length() == b.length()) {
               return b.compareTo(a);
            }
            return b.length() - a.length();
        });
        
        for(String num : nums) {
            queue.offer(num);
        }
        
        String result = null;
        for(int i = 0; i < k; i++) {
            result = queue.poll();
        }
        return result;
    }
}