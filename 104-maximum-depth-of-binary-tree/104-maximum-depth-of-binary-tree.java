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
    public int maxDepth(TreeNode root) {
        int l,r;
        if(root==null)
            return 0;
        else
        {
             l=maxDepth(root.left);
        r=maxDepth(root.right);
        if(l>r)
            return l+1;
        else
            return r+1;
        }         
    }
}