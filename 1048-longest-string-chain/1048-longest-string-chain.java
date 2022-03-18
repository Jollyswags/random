class Solution {
  
         Map<String, Integer> countMap = new HashMap();
    Set<String> set = new HashSet();
    public int longestStrChain(String[] words) {
        Arrays.sort(words);
		
        countMap.clear();
        set.clear();
        
        for (String word: words) {
            set.add(word);
        }
        
        int max = 0;
        for (String word: words) {
            max = Math.max(max, chainLength(word));
        }
        
        return max;
    }
    
    private int chainLength(String word) {
        if (!set.contains(word)) return 0;       // We don't care about words that are not in the array
        
        if (countMap.containsKey(word)) {
            return countMap.get(word);
        }
        
		// If the word is in the array, we begin finding it's chain.
        int maxLength = 0;
        StringBuilder stb = new StringBuilder(word);
        for (int i = 0; i < word.length(); i++) {
            stb.deleteCharAt(i);
            maxLength = Math.max(maxLength, chainLength(stb.toString()));
            stb.insert(i, word.charAt(i));
        }
        
        countMap.put(word, maxLength + 1);
        
        return countMap.get(word);
    }
}