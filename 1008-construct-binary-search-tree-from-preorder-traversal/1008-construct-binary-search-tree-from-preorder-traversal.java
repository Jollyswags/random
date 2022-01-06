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
    int idx;
    int n;
    int preorder[];
    public TreeNode bstFromPreorder(int[] preorder) {
        idx=0;
        n=preorder.length;
        this.preorder=preorder;
        return helper(Integer.MIN_VALUE,Integer.MAX_VALUE);
        
    }
    public TreeNode helper(int l, int r)
    {
        if(idx==n)
            return null;
        int val=preorder[idx];
        if(val<l || val>r)
            return null;
        idx++;
        TreeNode root=new TreeNode(val);
        root.left=helper(l,val);
        root.right=helper(val,r);
        return root;
    }
}