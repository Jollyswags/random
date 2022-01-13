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
    class Node
    {
        int parent;
        int depth;
    }
    Node xNode,yNode;
    public boolean isCousins(TreeNode root, int x, int y) {
        xNode=new Node();
        yNode=new Node();
        dfs(root,x,y,0,0);
        if(xNode.parent!=yNode.parent && xNode.depth==yNode.depth)
            return true;
        else
            return false;
    }
    public void dfs(TreeNode root,int x,int y,int parent,int depth)
    {
        if(root==null)
            return;
        if(x==root.val)
        {
            xNode.parent=parent;
            xNode.depth=depth;
        }
        else
            if(y==root.val)
            {
                yNode.parent=parent;
                yNode.depth=depth;
            }
        dfs(root.left,x,y,root.val,depth+1);
        dfs(root.right,x,y,root.val,depth+1);
    }
}