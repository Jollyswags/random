class Solution {
       public TreeNode recoverFromPreorder(String traversal) {
        return dfs(traversal.toCharArray(), 0);
    }
    
    int nextDepth = 0, nextVal = 0, p = 0;
    
    TreeNode dfs(char[] s, int d) {
        if (nextVal == 0 && p == s.length) {
            return null;
        }
        
        if (nextVal == 0) {
            while (p < s.length && s[p] == '-') {
                nextDepth++;
                p++;
            }
            while (p < s.length && s[p] != '-') {
                nextVal = nextVal * 10 + s[p] - '0';
                p++;
            }
        }
        
        if (nextDepth < d) {
            return null;
        }
        
        TreeNode node = new TreeNode(nextVal);
        nextVal = 0; nextDepth = 0;
        
        node.left = dfs(s, d+1);
        node.right = dfs(s, d+1);
        
        return node;
    }
}