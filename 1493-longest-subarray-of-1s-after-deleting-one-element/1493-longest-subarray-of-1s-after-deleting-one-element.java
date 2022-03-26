class Solution {
    public int longestSubarray(int[] nums) {
        // counts the max ones of the entire array.
        int maxOnesCount = 0;
        // the starting index of the window
        int startIndex = 0;
        // the max length of 1's with element to be deleted
        int maxLen = 0;
        // iterate through the array
        for (int endIndex = 0; endIndex < nums.length; endIndex++) {
            // if the number at current index is 1 than increment the maxOnesCount
            if (nums[endIndex] == 1) {
                maxOnesCount++;
            }
            
            // get the current length of the window, for example, for window [1, 1, 1, 0, 1], 
			// the startIndex is 0, endIndex is 4, and the length is 4 - 0 + 1 = 5;
            int currWindowSize = endIndex - startIndex + 1;
            // if the current window size mins the count of ones greater than 1, then it is time to shrink the window
            if (currWindowSize - maxOnesCount > 1) {
                // if the number at startIndex is one, then we should decrement the ones count by 1
                if (nums[startIndex] == 1) {
                    maxOnesCount--;
                }
                // increment the startIndex
                startIndex++;
            }
            
            // check if the curr window size is greater than the max len
            maxLen = Math.max(maxLen, endIndex - startIndex + 1);
        }
        
        // return the max length - 1 as we need to delete one element from the array.
        return maxLen - 1; 
    }
}