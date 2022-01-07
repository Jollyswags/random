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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        helper(root,0);
        int i;
        for(i=0;i<ans.size();i++)
           list.add(Collections.max(ans.get(i)));
        return list;
    }
    public void helper(TreeNode root, int level)
    {
        if(root==null)
            return;
        if(ans.size()<=level)
            ans.add(new ArrayList<Integer>());
        ans.get(level).add(root.val);
        helper(root.left,level+1);
        helper(root.right,level+1);
    }
}