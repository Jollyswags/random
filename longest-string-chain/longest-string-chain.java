class Solution {
    public int longestStrChain(String[] words) {
             Map<String, Integer> dp = new HashMap<>();

        // Sorting the list in terms of the word length.
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int longestWordSequenceLength = 1;

        for (String word : words) {
            int presentLength = 1;
            // Find all possible predecessors for the current word by removing one letter at a time.
            for (int i = 0; i < word.length(); i++) {
                StringBuilder temp = new StringBuilder(word);
                temp.deleteCharAt(i);
                String predecessor = temp.toString();
                int previousLength = dp.getOrDefault(predecessor, 0);
                presentLength = Math.max(presentLength, previousLength + 1);
            }
            dp.put(word, presentLength);
            longestWordSequenceLength = Math.max(longestWordSequenceLength, presentLength);
        }
        return longestWordSequenceLength;
    }
    
}
/*et NN be the number of words in the list and LL be the maximum possible length of a word.

Time complexity O(N⋅logN+NL^2)=N(logN+L^2)
 )).

Sorting a list of size NN takes O(N \log N)O(NlogN) time. Next, we use two for loops in which the outer loop runs for O(N)O(N) iterations and the inner loop runs for O(L ^ 2)O(L 
2
 ) iterations in the worst case scenario. The first LL is for the inner loop and the second LL is for creating each predecessor. Thus the overall time complexity is O(N \log N + (N \cdot L ^ 2))O(NlogN+(N⋅L 
2
 )) which equals O(N \cdot (\log N + L ^ 2))O(N⋅(logN+L 
2
 )).

Space complexity: O(N).

We use a map to store the length of the longest sequence formed with each of the NN words as the end word.*/