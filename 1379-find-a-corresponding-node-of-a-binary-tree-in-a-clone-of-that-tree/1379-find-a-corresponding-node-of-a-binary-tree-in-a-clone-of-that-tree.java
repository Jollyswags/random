/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode t, ans;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        t=target;
        inorder(original,cloned);
        return ans;
    }
    public void inorder(TreeNode o, TreeNode c)
    {
        if(o==null)
            return;
        inorder(o.left,c.left);
        if(t==o)
            ans=c;
        inorder(o.right, c.right);
    }
}