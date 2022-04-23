class Solution {
    int root[];
    int rank[];
    public int findCircleNum(int[][] isConnected) 
    {
        int count=0;
        int l=isConnected.length;
        root=new int[l];
        rank=new int[l];
        int i,j;
        for(i=0;i<l;i++)
        {
            root[i]=i;
            rank[i]=1;
        }
        for(i=0;i<l;i++)
            for(j=0;j<l;j++)
                if(isConnected[i][j]==1)
                    union(i,j);
        for(i=0;i<l;i++)
        {
            if(root[i]==i)
                count++;
        }
        return count;
    }
    public int find(int x)
    {
        if(root[x]==x)
            return x;
        return root[x]=find(root[x]);
    }
    public void union(int x, int y)
    {
        int rootX=find(x);
        int rootY=find(y);
        if(rank[rootX]>rank[rootY])
        {
            root[rootY]=root[rootX];
            
        }
        else
            if(rank[rootX]<rank[rootY])
            {
                root[rootX]=root[rootY];
            }
        else
        {
            root[rootY]=rootX;
            rank[rootX]++;
        }
    }
}
// TC=O(N)
//SC=O(N)