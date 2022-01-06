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
    int sum,  maxlevel=0;
    public int deepestLeavesSum(TreeNode root) {
        
        helper(root,0);
        return sum;
    }
    public void helper(TreeNode root, int level)
    {
        if(root==null)
            return;
        if(level>maxlevel)
        {
            maxlevel=level;
            sum=0;
        }
        if(level==maxlevel)
        {
            sum+=root.val;
        }
        helper(root.left,level+1);
        helper(root.right,level+1);
    }
}