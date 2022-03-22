class Solution {
    public String getSmallestString(int n, int k) {
              StringBuilder sb = new StringBuilder();
        
		// Build the required String backwards
        for(int i=n;i>0;i--){
		// for each position of the resultant string try all the possible letters but backwards i.e., from z->a
            for(int j=26;j>0;j--){
			// once the appropriate letter is found add it to the resultant stringBuilder and reduce the k (the total sum).
                if((k-j)>=i-1){
                    sb.append((char)(j+96));
                    k=k-j;
					// exit the inner loop as now we again need to repeat this process for (i-1)th position.
                    break;
                }
            }
        }
		
        return sb.reverse().toString();
    }
}