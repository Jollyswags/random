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
    int ans=0;
    Set<TreeNode> set=new HashSet<>();
    public int minCameraCover(TreeNode root) {
        set.add(null);
        dfs(root,null);
        return ans;
    }
    public void dfs(TreeNode root, TreeNode par)
    {
        if(root==null)
            return;
        dfs(root.left,root);
        dfs(root.right,root);
        if(par==null && !set.contains(root) || !set.contains(root.left) || !set.contains(root.right))
        {
            ans++;
            set.add(root);
            set.add(par);
            set.add(root.left);
            set.add(root.right);
        }
    }
}