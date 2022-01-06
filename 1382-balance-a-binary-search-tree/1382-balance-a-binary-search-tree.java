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
    List<Integer> l=new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return helper(l,0,l.size()-1);
        
    }
    public void inorder(TreeNode root)
    {
        if(root==null)
            return;
        inorder(root.left);
        l.add(root.val);
        inorder(root.right);
    }
    public TreeNode helper(List<Integer> l, int s, int r)
    {
        if(s>r)
            return null;
        int mid=(s+r)/2;
        TreeNode root=new TreeNode(l.get(mid));
        root.left=helper(l,s,mid-1);
        root.right=helper(l,mid+1,r);
        return root;
    }
}