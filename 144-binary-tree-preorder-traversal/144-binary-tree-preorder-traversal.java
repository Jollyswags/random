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
    public List<Integer> preorderTraversal(TreeNode root) {
           ArrayList preorder  = new ArrayList<>();
        if(root == null) return preorder;
        
        Stack<TreeNode>st = new Stack<>();
        st.push(root);
        while( !st.isEmpty() ){
            root = st.pop(); 
            preorder.add(root.val);
            if(root.right != null) 
                st.add(root.right);
            if(root.left != null)
                st.add(root.left);
                        
        }
        return preorder;        
    }
}