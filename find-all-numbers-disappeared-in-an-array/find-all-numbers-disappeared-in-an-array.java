class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList();
        int[] counts = new int[nums.length + 1];
        for(int n : nums){
            counts[n]++;
        }
        for(int i=1; i<counts.length; i++){
            if(counts[i]<1)
                list.add(i);
        }
        return list; 
    }
}