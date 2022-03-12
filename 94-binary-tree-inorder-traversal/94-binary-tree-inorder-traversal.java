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
    List<Integer> l;
    public List<Integer> inorderTraversal(TreeNode root) {
        l=new ArrayList<>();
        helper(root);
        return l;
        
        
    }
    public void helper(TreeNode root)
    {
        if(root==null)
            return;
        helper(root.left);
        l.add(root.val);
        helper(root.right);
    }
}