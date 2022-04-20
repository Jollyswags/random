class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length,l = 0, r = findmax(bloomDay); 
        if ((m*k)>n) return -1;
        while (l < r) {
            int mid = l+(r - l) / 2, count = 0, total = 0;//count the flowers for each bouq,total is bouq number
            for (int i : bloomDay){
                if(i>mid) count = 0;
                else if (++count>= k) {
                        total++; 
                        count = 0;
                    }
                
            }
                        
            if (total < m)  l = mid + 1; 
            else  r = mid;
            
        }
        return l;
    }
        private int findmax(int[] A){
        int max=0;
        for (int i :A){
            if (i>max) max = i;
        }
        return max;
        }
    }    