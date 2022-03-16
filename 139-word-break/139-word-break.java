class Solution {
     private HashMap<String, Boolean> memo;

    private boolean dp(String s) {
        if (!memo.containsKey(s)) {
            for (int i = 1; i < s.length(); i++) {
                if (dp(s.substring(0, i)) && dp(s.substring(i))) {
                    memo.put(s, true);
                    break;
                }
            }
        }
        if (!memo.containsKey(s)) {
            memo.put(s, false);
        }
        return memo.get(s);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        this.memo = new HashMap<>();
        for (String str : wordDict) {
            memo.put(str, true);
        }
        return dp(s);
    }
}