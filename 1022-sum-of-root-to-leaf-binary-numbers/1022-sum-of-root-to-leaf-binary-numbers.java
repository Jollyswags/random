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
   int rootToLeaf = 0;
    
    public void preorder(TreeNode root, int currNumber) {
        if(root==null)
            return;
        currNumber= currNumber<<1 | root.val;
        if(root.left==null && root.right==null)
        rootToLeaf+=currNumber;
        preorder(root.left,currNumber);
        preorder(root.right,currNumber);
        }
    

    public int sumRootToLeaf(TreeNode root) {
        preorder(root, 0);
        return rootToLeaf;
    }
}