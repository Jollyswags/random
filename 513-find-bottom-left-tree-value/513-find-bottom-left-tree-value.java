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
    List<List<Integer>> ans=new ArrayList<>();
    public int findBottomLeftValue(TreeNode root) {
        traverse(root,0);
        return ans.get(ans.size()-1).get(0);
    }
    public void traverse(TreeNode root,int level)
    {
        if(root==null)
            return;
        if(ans.size()<=level)
            ans.add(new ArrayList<Integer>());
        ans.get(level).add(root.val);
        traverse(root.left,level+1);
        traverse(root.right,level+1);
    }
}