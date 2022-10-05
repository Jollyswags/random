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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1)
        {
            TreeNode node=new TreeNode(val);
            node.left=root;
            return node;
        }
        insert(val,root,1,depth);
        return root;        
    }
    public void insert(int v, TreeNode node, int d, int n)
    {
        if(node==null)
            return;
        if(d==n-1)
        {
            TreeNode t=node.left;
            node.left=new TreeNode(v);
            node.left.left=t;
            t=node.right;
            node.right=new TreeNode(v);
            node.right.right=t;
            
        }
        else
        {
            insert(v,node.left,d+1,n);
            insert(v,node.right,d+1,n);
        }
    }
}