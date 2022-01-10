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
    public static int maxSum(TreeNode root, int[] maxi){
        if(root == null)
            return 0;
 
        int leftSum = Math.max(0, maxSum(root.left, maxi));
        int rightSum = Math.max(0, maxSum(root.right, maxi));
        maxi[0] = Math.max(maxi[0], (root.val + leftSum + rightSum));
        return root.val + Math.max(leftSum, rightSum);
    }
    public int maxPathSum(TreeNode root) {
        int[] ans = {Integer.MIN_VALUE};
        maxSum(root, ans);
        
        return ans[0];        
    }
}