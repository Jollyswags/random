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
    int maxsum=0;
    List<Integer>ans=new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> real = new ArrayList<>();
         List<Integer> left = new ArrayList<>();
        if(root==null){
            return real;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = q.size();
            while(size-->0){
                if(q.peek().left!=null)  {q.offer(q.peek().left); }
                if(q.peek().right!=null) {q.offer(q.peek().right);}
                temp.add(q.poll().val);
            }
            
            ans.add(temp);
            
        }
        for(List<Integer> x: ans)
            left.add(x.get(0));
          System.out.println(left);  
        
        for(List<Integer> x : ans){
            real.add(x.get(x.size()-1));
        }
        System.out.println(real);
        return real;
    }
}