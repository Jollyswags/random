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
    int preorderindex=0;
    HashMap<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       int i;
        for(i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        return build(preorder,0,preorder.length-1);
    }
    public TreeNode build(int preorder[],int start, int end)
    {
        if(start>end)
            return null;
        int val=preorder[preorderindex++];
        TreeNode root=new TreeNode(val);
        root.left=build(preorder,start,map.get(val)-1);
        root.right=build(preorder,map.get(val)+1,end);
        return root;
    }
}