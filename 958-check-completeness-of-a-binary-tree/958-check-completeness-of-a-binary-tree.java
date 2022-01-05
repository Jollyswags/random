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
    public boolean isCompleteTree(TreeNode root) {
        boolean isSeen=false;
        
        Queue<TreeNode>Q=new LinkedList<>();
        Q.add(root);
        
        while(!Q.isEmpty())
        {
            TreeNode temp=Q.poll();
            if(temp==null){isSeen=true;}
            else
            {
                if(isSeen)return false;
                Q.add(temp.left);
                Q.add(temp.right);
            }
        }
        return true;
        
    }
}