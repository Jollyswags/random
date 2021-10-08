class Solution {
      public int countSubstrings(String s) {
      int ans = 0;

        for (int i = 0; i < s.length(); ++i) {
            // odd-length palindromes, single character center
            ans += countPalindromesAroundCenter(s, i, i);

            // even-length palindromes, consecutive characters center
            ans += countPalindromesAroundCenter(s, i, i + 1);
        }

        return ans;
    }

    private int countPalindromesAroundCenter(String ss, int lo, int hi) {
        int ans = 0;

        while (lo >= 0 && hi < ss.length()) {
            if (ss.charAt(lo) != ss.charAt(hi))
                break;      // the first and last characters don't match!

            // expand around the center
            lo--;
            hi++;

            ans++;
        }

        return ans;
    }
}
/*Multiple palindromes have the same centers. If we choose a center, we can continue to expand around it as long as we can make larger and larger palindromes.

Let's take the string "lever" as an example: if you choose the character 'v' as the center, one can see that the palindromes "v" and "eve" are possible. However, the final expansion "lever" is not a palindrome (the first and last characters don't match).

Algorithm

We choose all possible centers for potential palindromes:

Every single character in the string is a center for possible odd-length palindromes
Every pair of consecutive characters in the string is a center for possible even-length palindromes.
For every center, we can expand around it as long as we get palindromes (i.e. the first and last characters should match).
Complexity Analysis

Time Complexity: O(N^2) for input string of length N. The total time taken in this approach is dictated by two variables:

The number of possible palindromic centers we process.
How much time we spend processing each center.
The number of possible palindromic centers is 2N-12N−1: there are NN single character centers and N-1N−1 consecutive character pairs as centers.

Each center can potentially expand to the length of the string, so time spent on each center is linear on average. Thus total time spent is N (2N-1) ~ N(2N−1)≃N^2
 .

Space Complexity: O(1). We don't need to allocate any extra space since we are repeatedly iterating on the input string itself.*/