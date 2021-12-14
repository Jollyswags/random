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
   public List<Integer> l=new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        helper(root);
        return buildBST(l,0,l.size()-1);
        
    }
    public void helper(TreeNode root)
    {
        if(root==null)
            return;
        helper(root.left);
        l.add(root.val);
        helper(root.right);
    }
    public TreeNode buildBST(List<Integer> l, int start, int end)
    {
        if(start>end)
            return null;
        int mid=(start+end)/2;
        TreeNode temp=new TreeNode(l.get(mid));
        temp.left=buildBST(l,start,mid-1);
        temp.right=buildBST(l,mid+1,end);
        return temp;
    }
}