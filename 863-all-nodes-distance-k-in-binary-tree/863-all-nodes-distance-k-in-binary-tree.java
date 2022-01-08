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
    HashMap<TreeNode,TreeNode> parent=new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs(root,null);
        Queue<TreeNode> queue=new LinkedList<>();
        
        Set<TreeNode> set=new HashSet<>();
        queue.add(null);
        queue.add(target);
        set.add(target);
        set.add(null);
        int dist=0;
        while(!queue.isEmpty())
        {
            TreeNode node=queue.poll();
            if(node==null)
            {
                if(dist==k)
                {
                    List<Integer> ans=new ArrayList<>();
                    for(TreeNode t:queue)
                    {
                        ans.add(t.val);
                        
                    }
                    return ans;
                }
                queue.offer(null);
                dist++;
            }
            else
            {
                if(!set.contains(node.left))
                {
                    set.add(node.left);
                    queue.offer(node.left);
                }
                if(!set.contains(node.right))
                {
                    set.add(node.right);
                    queue.offer(node.right);
                }
                TreeNode par=parent.get(node);
                if(!set.contains(par))
                {
                    set.add(par);
                    queue.offer(par);
                }
            }
        }
        return new ArrayList<>();
    }
    public void dfs(TreeNode node, TreeNode par)
    {
        if(node==null)
            return;
        parent.put(node,par);
        dfs(node.left,node);
        dfs(node.right,node);
        
    }
}