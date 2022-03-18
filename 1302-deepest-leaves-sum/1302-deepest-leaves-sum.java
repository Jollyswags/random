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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        List<List<Integer>> ans=new ArrayList<>();
        while(!q.isEmpty())
        {
            List<Integer> list=new ArrayList<>();
            int s=q.size();
            for(int i=0;i<s;i++)
            {
                TreeNode node =q.poll();
                list.add(node.val);
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            }
            ans.add(list);
        }
        int sum=0;
        for(int x: ans.get(ans.size()-1))
        {
            sum+=x;
        }
        return sum;
    }
}