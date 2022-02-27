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
    HashMap<Integer,Integer> map=new HashMap<>();
    int maxwidth=0;
    public int widthOfBinaryTree(TreeNode root) {
        width(root,0,0);
        return maxwidth;
    }
    public void width(TreeNode root, int depth,int pos)
    {
        if(root==null)
            return;
        if(!map.containsKey(depth))
            map.put(depth,pos);
        maxwidth=Math.max(maxwidth,pos-map.get(depth)+1);
        width(root.left, depth+1, 2*pos);
        width(root.right, depth+1, 2*pos +1);
    }
}