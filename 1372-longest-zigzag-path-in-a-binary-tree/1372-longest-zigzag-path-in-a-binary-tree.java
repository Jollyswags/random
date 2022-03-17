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
   int max=0;
    public int longestZigZag(TreeNode root) {
        solve(root,true);
        return max;        
    }
    public int solve(TreeNode root, boolean isRight)
    {
        if(root==null)
            return 0;
        int left=solve(root.left,false);
        int right=solve(root.right,true);
        max=Math.max(max,Math.max(left,right));
        return isRight?left+1:right+1;
    }
}