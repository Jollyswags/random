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
    String ans="~";
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return ans;        
    }
    public void dfs(TreeNode node, StringBuilder sb)
    {
        if(node==null)
            return;
        sb.append((char)('a'+node.val));
        if(node.left==null && node.right==null)
        {
            sb.reverse();
            String s=sb.toString();
            sb.reverse();
            if(s.compareTo(ans)<0)
            {
                ans=s;
            }
        }
            dfs(node.left,sb);
            dfs(node.right,sb);
            sb.deleteCharAt(sb.length()-1);
        
    }
}