class Solution {
    public List<Integer> findAnagrams(String s, String p) {
               int[] count = new int[256];
        for (char c : p.toCharArray()) 
            count[c]++;
        int left = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]--;
            while (count[s.charAt(i)] < 0) 
                count[s.charAt(left++)]++;
            if (i - left + 1 == p.length())
                res.add(left);
        }
        return res;
    }
}