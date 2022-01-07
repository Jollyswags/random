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
    HashMap<Integer, Integer> map=new HashMap<>();
    public int maxLevelSum(TreeNode root) 
    {
       
        helper(root,1);
        
        return Collections.max(map.entrySet(),(entry1,entry2)->entry1.getValue()-entry2.getValue()).getKey();
            
    }
    public void helper(TreeNode root, int level)
    {
        if(root==null)
            return;
        map.put(level,map.getOrDefault(level,0)+root.val);
        helper(root.left,level+1);
        helper(root.right,level+1);
    }
}