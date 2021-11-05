class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
         List<Integer> ans = new ArrayList(), list = new ArrayList();
        
        for (int num : nums1) list.add(num);
        
        for (int i = 0; i < nums2.length; i++)
            if (list.contains(nums2[i]) && !ans.contains(nums2[i]))
                ans.add(nums2[i]);
        
        for (int i = 0; i < nums3.length; i++)
            if (list.contains(nums3[i]) && !ans.contains(nums3[i]))
                ans.add(nums3[i]);
        
        list.clear();
        
        for (int num : nums2) list.add(num);
        
        for (int i = 0; i < nums3.length; i++) 
            if (list.contains(nums3[i]) && !ans.contains(nums3[i])) 
                ans.add(nums3[i]);
        
        return ans;
    }
}