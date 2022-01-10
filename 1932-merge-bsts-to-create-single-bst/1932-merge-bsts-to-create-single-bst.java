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
  
    public boolean traverse(HashMap<Integer,TreeNode>root,TreeNode curr,int min ,int max){
        if(curr==null) return true;
        if(curr.val<=min||curr.val>=max) return false;
        if(curr.left==null&&curr.right==null){
            int v=curr.val;
            if(root.containsKey(v)) {
                TreeNode temp=root.get(v);
                if(temp.left!=null) curr.left=temp.left;
                if(temp.right!=null) curr.right=temp.right;
                root.remove(v);
            }
        }
        if(traverse(root,curr.left,min,curr.val)&&traverse(root,curr.right,curr.val,max)) return true;
        return false;
    }
    public TreeNode canMerge(List<TreeNode> trees) {
        HashMap<Integer,TreeNode>root=new HashMap<>();
        HashMap<Integer,Integer>count=new HashMap<>();
        for(TreeNode tree:trees){
            root.put(tree.val,tree);
            count.put(tree.val,count.getOrDefault(tree.val,0)+1);
            if(tree.left!=null) count.put(tree.left.val,count.getOrDefault(tree.left.val,0)+1);
            if(tree.right!=null) count.put(tree.right.val,count.getOrDefault(tree.right.val,0)+1);
        }
        for(TreeNode tree:trees){
            if(count.get(tree.val)!=1) continue;
            boolean check=traverse(root,tree,Integer.MIN_VALUE,Integer.MAX_VALUE);
            if(check&&root.size()<=1) return tree;
            return null;
        }
        return null;
    }
}