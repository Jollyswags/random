class Solution {
    public int maximumUniqueSubarray(int[] nums) {
       HashMap<Integer,Integer> hmap=new HashMap<>();
        int i=0;
        int j=0;
        int sum=0;
        int finalSum=0;
        while(j<nums.length){
            if(hmap.containsKey(nums[j]) && hmap.get(nums[j]) > 0){
                
                while(hmap.get(nums[j])>0){
                    sum-=nums[i];
                    hmap.put(nums[i],hmap.get(nums[i])-1);
                    i++;
                }
            }
            else{
                hmap.put(nums[j],hmap.getOrDefault(nums[j],0)+1);
                sum+=nums[j];
                j++;
            }
            
            finalSum=Math.max(finalSum,sum);
        }
       
        
        return finalSum; 
    }
}