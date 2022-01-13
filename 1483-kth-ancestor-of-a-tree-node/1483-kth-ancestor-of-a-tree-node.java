class TreeAncestor {
int tree[][];
    int maxDepth;
    public TreeAncestor(int n, int[] parent) {
        int pre;
        maxDepth=(int)(Math.log(n)/Math.log(2)) +1;
        tree=new int[maxDepth][n];
        tree[0]=parent;
        int i,j;
        for(i=1;i<maxDepth;i++)
            for(j=0;j<n;j++)
            {
                pre=tree[i-1][j];
                tree[i][j]= pre==-1?-1:tree[i-1][pre];
            }
    }
    
    public int getKthAncestor(int node, int k) {
        int max=maxDepth;
        int num;
        while(k>0 && node>-1)
        {
            num=1<<max;
            if(k>=1<<max)
            {
                node=tree[max][node];
                k-=1<<max;
            }
            else
                max-=1;
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */