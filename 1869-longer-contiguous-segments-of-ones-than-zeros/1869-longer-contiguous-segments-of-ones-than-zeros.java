class Solution {
    public boolean checkZeroOnes(String s) {
      var maxZeros = 0;
	var maxOnes = 0;

	for (int i = 0, zeros = 0, ones = 0; i < s.length(); i++)
		if (s.charAt(i) == '0') {
			maxZeros = Math.max(maxZeros, ++zeros);
			ones = 0;
		} else {
			maxOnes = Math.max(maxOnes, ++ones);
			zeros = 0;
		}

	return maxOnes > maxZeros;  
    }
}