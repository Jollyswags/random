class Solution {
    public List<Integer> grayCode(int n) {
         List<Integer> result = new ArrayList<>(Arrays.asList(0));
  for (int i = 0; i < n; ++i) {
    int prependVal = (1 << i);
    int oldSize = result.size();
    for (int j = oldSize - 1; j >= 0; --j) {
      result.add(result.get(j) + prependVal);
    }
  }
  return result;
    }
}
//2^n