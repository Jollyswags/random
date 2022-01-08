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
    public List<Integer> rightSideView(TreeNode root) {
        traverse(root,0);
        List<Integer> result=new ArrayList<>();
        for(List<Integer> l:ans)
        {
            result.add(l.get(l.size()-1));
        }
        return result;
    }
    public void traverse(TreeNode root,int level)
    {
        if(root==null)
            return;
        if(ans.size()<=level)
            ans.add(new ArrayList<>());
        ans.get(level).add(root.val);
        traverse(root.left,level+1);
        traverse(root.right,level+1);
    }
}