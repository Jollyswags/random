class Solution {
    public int numTeams(int[] rating) {
         int len = rating.length;

		int[] up = new int[len]; 
		int[] down = new int[len];

		int count = 0;
        
        // first <r[i] <r[j] <r[k] order
        
        for(int i = 0; i < len; i++){
            for(int j = i; j >= 0; j--){
                if(rating[i] > rating[j]){
                    up[i]++;
                    count = count + up[j];
                }
            }
        }
        
        // second >r[i] >r[j] >r[k] order
		 for(int i = 0; i < len; i++){
            for(int j = i; j >= 0; j--){
				if (rating[i] < rating[j]) {
					down[i] += 1;
					count += down[j];
				}
			}
		}

		return count;
    }
}