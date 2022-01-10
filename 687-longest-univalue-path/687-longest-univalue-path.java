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
    public int longestUnivaluePath(TreeNode root) {
        arrowlength(root);
        return ans;
    }
    public int arrowlength(TreeNode root)
    {
        if(root==null)
            return 0;
         int arrowleft=0, arrowright=0;
        int left=arrowlength(root.left);
        int right=arrowlength(root.right);
        if(root.left!=null && root.left.val==root.val)
            arrowleft+=left+1;
        if(root.right!=null && root.right.val==root.val)
            arrowright+=right+1;
        ans=Math.max(ans,arrowleft+arrowright);
        return Math.max(arrowleft,arrowright);
    }
}