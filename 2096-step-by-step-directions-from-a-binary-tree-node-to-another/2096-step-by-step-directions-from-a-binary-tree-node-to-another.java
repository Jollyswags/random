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
     private boolean srcFound, destFound;
    private StringBuilder sb1 = new StringBuilder();
    private StringBuilder sb2 = new StringBuilder();
    
    public String getDirections(TreeNode root, int start, int dest) {
        if (root.val == start) srcFound = true;
        if (root.val == dest) destFound = true;
        
        dfs(root.left, true, start, dest);
        
        if (!srcFound) deleteLastChar(sb1); 
        if (!destFound) deleteLastChar(sb2);  

        dfs(root.right, false, start, dest);
        
        int delCount = 0;
        for (int i = 0; i < Integer.min(sb1.length(), sb2.length()); i++, delCount++) {
            if (sb1.charAt(i) != sb2.charAt(i)) break;
        }
        
        String s = "U".repeat(sb1.length() - delCount);
        return s + sb2.substring(delCount).toString();
    }
    
    private boolean dfs(TreeNode node, boolean isLeft, int start, int dest) {
        if (node == null) return false;
        
        if (!srcFound) sb1.append(isLeft ? 'L' : 'R');
        if (!destFound) sb2.append(isLeft ? 'L' : 'R');
        
        if (node.val == start) srcFound = true;
        else if (node.val == dest) destFound = true;
        
        if (srcFound && destFound) return true;
        
        if (dfs(node.left, true, start, dest)) return true;
        
        if (node.left != null && !srcFound) deleteLastChar(sb1);
        if (node.left != null && !destFound) deleteLastChar(sb2);
        
        if (dfs(node.right, false, start, dest)) return true;
        
        if (node.right != null && !srcFound) deleteLastChar(sb1);
        if (node.right != null && !destFound) deleteLastChar(sb2);
        
        return false;
    }
    
    private void deleteLastChar(StringBuilder sb) {
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
    }
}