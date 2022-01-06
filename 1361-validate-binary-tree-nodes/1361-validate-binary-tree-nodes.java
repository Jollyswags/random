class Solution {
     public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] indeg = new int[n];
        for(int i=0;i<n;i++){
            if(leftChild[i]!=-1) indeg[leftChild[i]]++;
            if(rightChild[i]!=-1) indeg[rightChild[i]]++;
        }
        int root=-1;
        for(int i=0;i<n;i++){
            if(indeg[i]==0) {
                if(root!=-1) return false;
                root=i;
            }
            else if(indeg[i]>1) return false;
        }
        if(root==-1) return false;
        boolean[] visited = new boolean[n];
        isValid(root, leftChild, rightChild, visited);
        int count = 0;
        for(int i=0;i<n;i++){
            if(visited[i]) count++;
        }
        return count == n;
    }
    private void isValid(int i, int[] left, int[] right, boolean[] visited){
        visited[i]=true;
        if(left[i]!=-1) isValid(left[i], left, right, visited);
        if(right[i]!=-1) isValid(right[i], left, right, visited);
    }
}