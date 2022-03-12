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
       // list to keep track of the pre order traversal
    List<Integer> preOrder = new ArrayList<>();
    
    public List<Integer> preorderTraversal(TreeNode root) {
        preOrderHelper(root);
        return preOrder;
    }
    
    public List<Integer> preOrderHelper(TreeNode current) {
        
        // base case, no node value
        if (current == null) {
            return null;
        }
        
        // pre order traversal is (root, left, right) so, use that logic when 
        // recursing
        preOrder.add(current.val);
        preOrderHelper(current.left);
        preOrderHelper(current.right);
        
        return preOrder;
    }
}