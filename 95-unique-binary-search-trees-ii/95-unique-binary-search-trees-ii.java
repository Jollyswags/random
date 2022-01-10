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
     public List<TreeNode> generateTrees(int n) {
        return recursion(1,n);
    }
    List<TreeNode> recursion(int start ,int end)
    {
        List<TreeNode> list = new ArrayList<>();
        if(start > end)
        {
            list.add(null);
            return list;
        }
        if(start == end)
        {
            list.add(new TreeNode(start));
            return list;
        }
        List<TreeNode> left,right;
        for(int i = start;i<=end;i++)
        {
            left = recursion(start,i-1);
            right = recursion(i+1,end);
            for(TreeNode lst : left)
            {
                for(TreeNode rst : right)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = lst;
                    root.right = rst;
                    list.add(root);
                }
            }
        }
        return list;
    }  
}