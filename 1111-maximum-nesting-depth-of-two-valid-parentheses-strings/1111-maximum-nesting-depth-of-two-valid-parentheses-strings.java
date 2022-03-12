class Solution {
    public int[] maxDepthAfterSplit(String seq) {
     char[] arr = seq.toCharArray();
        int l = arr.length;
        int[] res = new int[l];
        
        int deg = 0;
        int maxDegree = 0;
		
		
            
        for(int i=0; i<l; i++) {
            if (arr[i] == '(') {
                deg++;
                maxDegree = Math.max(maxDegree, deg);
            }
            else {
                deg--;
            }
        }
           int currdeg = 0;
        int groupBcounter = 0; 
		
        for(int i=0; i<l; i++) {
            if (arr[i]=='(') {
			
                if (currdeg >= maxDegree/2) {
                    res[i] = 1;
                    groupBcounter++;
                }
                currdeg++;
            }
            else {
                currdeg--;
		
                if (groupBcounter > 0) {
                    res[i] = 1;
                    groupBcounter--;
                }
            }
        }
        return res;
    }
}