class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
         Arrays.sort(nums1);
        Arrays.sort(nums2);
        Arrays.sort(nums3);
        Arrays.sort(nums4);
    int count = 0;
		
		var map = new HashMap<Integer, Integer>();
		for (int m: nums1) {
			for (int n: nums2) {
				map.put(m+n, map.getOrDefault(m+n,0)+1);
			}
		}
		
		for (int m: nums3) {
			for (int n: nums4) {
				count += map.getOrDefault(-(m + n),0);
			}
		}
		
		return count;
    }
}
//n^2
//n