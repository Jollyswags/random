class Solution {
    public int numTeams(int[] rating) {
        int ans= 0;
        for(int i= 1; i<rating.length; i++)
        {
            int less[]= new int[2];
            int greater[]= new int[2];
            for(int j= 0; j< rating.length ;j++)
            {
                if(rating[i]<rating[j])
                    ++less[j>i?1:0];
                else
                    if(rating[i]>rating[j])
                        ++greater[j>i?1:0];
            }
            ans+= less[0]*greater[1] + less[1]*greater[0];
        }
        return ans;
        
    }
}