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
    int postindex=0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer, Integer> map=new HashMap();
        int i;
        for(i=0;i<postorder.length;i++)
            map.put(postorder[i],i);
        return helper(preorder,postorder,map,0,postorder.length-1);
    }
    public TreeNode helper(int[] preorder, int[] postorder, HashMap<Integer,Integer> map,int s, int e)
    {
        if(s>e)
            return null;
        TreeNode root = new TreeNode(preorder[postindex++]);
        if(s==e)
           return root;
        int i=map.get(preorder[postindex]);
      root.left = helper(preorder,postorder,map,s,i);
      root.right=helper(preorder,postorder,map,i+1,e-1);
        return root;
    }
}