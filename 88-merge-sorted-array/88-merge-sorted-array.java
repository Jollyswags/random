class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
          int p1 = 0;
        int p2 = 0;
        while(p1 < m && p2 < n){
            if(nums1[p1] > nums2[p2]){
                for(int i = m-1; i>=p1; i--){
                    nums1[i+1] = nums1[i];
                }
                nums1[p1] = nums2[p2];
                p2++;
                m++;
            }
            else{
                p1++;
            }
        }
        while(p2 < n){
            nums1[m] = nums2[p2];
            p2++;
            m++;
        }
    }
}