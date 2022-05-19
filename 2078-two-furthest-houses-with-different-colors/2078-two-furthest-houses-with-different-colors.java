class Solution {
    public int maxDistance(int[] colors) {
         //  left pointer 
		int l = 0;
        // right pointer 
		int r = colors.length - 1;
	    // while loop until the pointers have overlap
       
        // trivial return value 
        int res = 0; 
		while (r > l) {
            // we have found the answer 
			if (colors[l] != colors[r]) {
				if (Math.abs(l - r) > res) {
					return  Math.abs(l - r);
					
				}

			} else {
                // i -> to find next value for l pointer
				int i = l;
                // j -> to find next value for r pointer 
				int j = r;
                // iterate over array  until find a different value than current from starting l pointer 
				while (colors[i] == colors[l])
					i++;
                // iterate over array until find a different value than current from starting r pointer 
				while (colors[j] == colors[r])
					j--;
                // decide which is the minimum value 
				if (Math.abs(l - i) < Math.abs(j - r))
					l = i;
				else
					r = j;

			}

		}
		return res;
    }
}