class Solution {
    public int subarraysDivByK(int[] nums, int k) {
          Map<Integer, Integer> freqMap = new HashMap<>();
        freqMap.put(0,1);
        int cumSum = 0;
        
        int resp = 0;
        for(int i=1;i<=nums.length;++i) {
            cumSum +=nums[i-1];
            int rem = cumSum%k < 0? cumSum%k + k : cumSum%k;
            if(freqMap.containsKey(rem)) {
                resp+=freqMap.get(rem);
            }
            freqMap.put(rem, freqMap.getOrDefault(rem, 0)+1);
        }
        
        return resp;
    }
}