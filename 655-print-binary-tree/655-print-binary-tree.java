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
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int width = (int)Math.pow(2, height) - 1;
        
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0; i < height; i++) {
            List<String> list = new ArrayList<>(Collections.nCopies(width, ""));
            ans.add(list);
        }
        
        traverse(root, 0, width, height, 0, ans);
        return ans;
    }
    
    public void traverse(TreeNode root, int lo, int hi, int height, int level, List<List<String>> ans) {

        if(root == null || level == height) {
            return;
        }
        
        int m = lo + ((hi - lo) >> 1);
        ans.get(level).set(m, String.valueOf(root.val));
        
        traverse(root.left, lo, m - 1, height, level+1, ans);
        traverse(root.right, m + 1, hi, height, level+1, ans);
    }    
    
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}