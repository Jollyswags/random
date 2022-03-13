class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for(String word : words) set.add(word);     
        for(String word : words) helper(result, set, word);    
        return result;
    }    
    private void helper(List<String> list, HashSet<String> set, String word){
        if(word.length() == 0) return;
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for(int i = 0; i < word.length(); i++){
            if(!dp[i]) continue;
            for(int j = i + 1; j < dp.length; j++){
                if(i == 0 && j == word.length()) continue;
                if(set.contains(word.substring(i,j)))dp[j] = true;                 
            }
        }            
        if(dp[dp.length - 1]) list.add(word);       
    }
}