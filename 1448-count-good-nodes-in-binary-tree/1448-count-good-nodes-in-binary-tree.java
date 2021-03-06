/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count=0;
    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return count;
    }
    public void dfs(TreeNode root, int maxsofar)
    {
        if(root==null)
            return;
        if(root.val>=maxsofar)
            count++;
        //if(root.right!=null)
            dfs(root.right,Math.max(maxsofar,root.val));
        //if(root.left!=null)
            dfs(root.left,Math.max(maxsofar,root.val));
    }
}