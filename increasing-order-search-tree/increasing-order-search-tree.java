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
    TreeNode t;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans=new TreeNode(0);
        t=ans;
       
        helper(root);
      return ans.right;
        
    }
    public void helper(TreeNode root)
    {
        if(root==null)
            return;
        helper(root.left);
        root.left=null;
       t.right=root;
        t=root;
        
        helper(root.right);
        
        
    }
}