class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> row=new ArrayList<>();
        List<Integer> col;
        int i,j;
        for(i=0;i<n;i++)          
        {
            col=new ArrayList<>();
            if(i==0)
            {
                col.add(1);
                row.add(col);
                continue;
            }
            
            for(j=0;j<=i;j++)
            {
                if(j==0)
                    col.add(1);
                else
                    if(j==i)
                    {
                        col.add(1);
                        row.add(col);
                        break;
                    }
                else
                {
                    List<Integer> a=row.get(i-1);
                    int x=a.get(j-1);
                    int y=a.get(j);
                    col.add(x+y);
                }
              
            }
        }
        return row;
        
    }
}