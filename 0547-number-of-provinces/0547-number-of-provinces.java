class Solution {
    
    //define default values
    int root[];
    int rank[];
    
    //find the root
    public int find(int x)
    {
        if(root[x]==x)
            return x;
        return root[x]=find(root[x]);
    }
    
    //union of two cities
    
    public void union(int x, int y)
    {
        //fetch the root values
        int rootX=find(x);
        int rootY=find(y);
        
        //make the node as root if it's rank is lesser
        if(rank[rootX]>rank[rootY])
            root[rootY]=root[rootX];
        else
            if(rank[rootX]< rank[rootY])
                root[rootX]=root[rootY];
        
        //if rank is same
        else
        {
            root[rootY]=rootX;
            rank[rootX]++;
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        
        //initialize value
        int l=isConnected.length;
        root=new int[l];
        rank=new int[l];
        int count=0;
        for(int i=0;i<l;i++)
        {
            root[i]=i;
            rank[i]=1;
        }
        
        //if cities are connected, lets perform union
        for(int i=0;i<l;i++)
            for(int j=0;j<l;j++)
            {
                if(isConnected[i][j]==1)
                    union(i,j);
            }
        
        //if a cities is it's own root, increase count
        for(int i=0;i<l;i++)
        {
            if(root[i]==i)
            {
                count++;
            }
        }
        
        return count;
    }
}