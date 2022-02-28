class Solution {
    public List<String> summaryRanges(int[] nums) {
         List<String> list = new ArrayList<>();
        if(nums == null) return null;
        int range= 0;
        for(int i=0;i<nums.length;i=i+(range+1))
        {
             range=0;
            for(int j=i;j<nums.length-1;j++)
            {
                if(nums[j]+1 != nums[j+1])
                    break;
                else range++;
            }
            if(range >= 1)
            list.add(String.valueOf(nums[i]) +"->"+String.valueOf(nums[i+range]));
            else 
            list.add(String.valueOf(nums[i]));    
        }
        return list;
    }
}