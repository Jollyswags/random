import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Arrays;
class Solution {
    public int[] kWeakestRows(int[][] nums, int k) {
        int m=nums.length;
        int n=nums[0].length;
        int i,j,count;
        for(i=0;i<m;i++)
        {
            count=0;
            for(j=0;j<n;j++)
            {
                if(nums[i][j]==0)
                    break;
                count++;
            }
            nums[i][0]=count;
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b) -> (a[1] != b[1] ? b[1] - a[1] : b[0] - a[0]));
        for(i=0;i<m;i++)
        {
            pq.offer(new int[]{i,nums[i][0]});
             if (pq.size() > k) {
                pq.poll();
             }
        }
         int result[]=new int[k];
            while(!pq.isEmpty())
            {
                result[--k]=pq.poll()[0];
            }
            return result;      
        }
}