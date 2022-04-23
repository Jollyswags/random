class Solution {
    public int subarrayBitwiseORs(int[] arr) {
          Set set = new HashSet<>();
      for (int i = 0; i < arr.length; i++) {
       set.add(arr[i]);
       for (int j = i - 1; j >= 0; j--) {
             if ((arr[i] | arr[j]) == arr[j]) {
                   break;
                 }
             arr[j] |= arr[i];
            set.add(arr[j]);
          }
         }
     return set.size();
    }
}
//nlogk k is max ele of arr
//n