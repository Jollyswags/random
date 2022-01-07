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
    int ans=0;
    public int maxAncestorDiff(TreeNode root) {
        helper(root,root.val,root.val);
        return ans;
    }
    public void helper(TreeNode root, int currmax,int currmin)
    {
        if(root==null)
            return;
        int diff=Math.max(Math.abs(root.val-currmin), Math.abs(root.val-currmax));
        ans=Math.max(ans,diff);
        currmax=Math.max(currmax,root.val);
        currmin=Math.min(currmin,root.val);
        helper(root.left,currmax,currmin);
        helper(root.right,currmax,currmin);
    }
}