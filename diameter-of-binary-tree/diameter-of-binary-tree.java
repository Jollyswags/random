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
    int d;
    public int diameterOfBinaryTree(TreeNode root) {
       d=0;
        dm(root);
        return d;
        
    }
    public int dm(TreeNode root)
    {
        if(root==null)
            return 0;
        int l=dm(root.left);
        int r=dm(root.right);
        d=Math.max(d,l+r);
        return Math.max(l,r)+1;
    }
}