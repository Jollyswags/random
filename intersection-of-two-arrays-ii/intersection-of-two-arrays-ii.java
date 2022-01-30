class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
     Set<Integer> set1 = new HashSet<>(nums1.length);
    Set<Integer> set2 = new HashSet<>(nums2.length);
    Map<Integer, Integer> freq1 = new HashMap<>(nums1.length);
    Map<Integer, Integer> freq2 = new HashMap<>(nums2.length);

    for(int i = 0; i < nums1.length; i++) {
      set1.add(nums1[i]);
      freq1.put(nums1[i], freq1.getOrDefault(nums1[i], 0) + 1);
    }

    for(int i = 0; i < nums2.length; i++) {
      set2.add(nums2[i]);
      freq2.put(nums2[i], freq2.getOrDefault(nums2[i], 0) + 1);
    }

    // let there be an intersect
    set1.retainAll(set2);
    
    List<Integer> ans = new ArrayList<>();
    for(int i : set1) {
      for(int j = 0; j < Math.min(freq1.getOrDefault(i, 0), freq2.getOrDefault(i, 0)); j++)
        ans.add(i);
    }

    int[] arr = new int[ans.size()];
    for(int i = 0; i < arr.length; i++)
      arr[i] = ans.get(i);

    return arr;
    }
}