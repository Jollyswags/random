class Solution {
    int root[];
    int rank[];
    public int findCircleNum(int[][] isConnected) {
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
            {
                if(isConnected[i][j]==1)
                    union(i,j);
                
            }
        int c=0;
        for(i=0;i<l;i++)
        {
            if(root[i]==i)
                c++;
        }
            
        return c;
    }
    public int find(int x)
    {
        if(x==root[x])
            return x;
        return root[x]=find(root[x]);
    }
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }
}