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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        traversal(root);
        return ans;
    }
    public void traversal(TreeNode root)
    {
        if(root==null)
            return;
        Deque<TreeNode> queue=new ArrayDeque<>();
        queue.addFirst(root);
        boolean flag=true;
        while(!queue.isEmpty())
        {
            int size=queue.size();
            LinkedList<Integer> level=new LinkedList<>();
            int i;
            for(i=0;i<size;i++)
            {
                TreeNode node=queue.removeLast();
                if(flag)
                    level.addLast(node.val);
                else
                    level.addFirst(node.val);
                if(node.left!=null)
                    queue.addFirst(node.left);
                if(node.right!=null)
                    queue.addFirst(node.right);
                
            }
            flag=!flag;
            ans.add(level);
        }
    }
}