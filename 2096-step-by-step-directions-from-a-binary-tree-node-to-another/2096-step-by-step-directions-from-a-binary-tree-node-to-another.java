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
    TreeNode start = null;
    TreeNode end = null;
    
    public String getDirections(TreeNode root, int startValue, int destValue) {
        
        if (root == null) return "";
        StringBuilder startSB = new StringBuilder();
        StringBuilder destSB = new StringBuilder();
        
        find(root, startValue, startSB);
        find(root, destValue, destSB);
        
        int i = 0, maxi = Math.min(startSB.length(), destSB.length());
        while (i < maxi) {
            int len1 = startSB.length();
            int len2 = destSB.length();
            if (startSB.charAt(len1 - 1) == destSB.charAt(len2 - 1)) 
            {
                startSB.setLength(len1-1);
                destSB.setLength(len2-1);
            }
            
            i++;
        }
        
        String left = "U".repeat(startSB.length());
        return left + destSB.reverse().toString();
    }
    
    private boolean find(TreeNode node, int value, StringBuilder sb) {
        if (node.val == value) {
            return true;
        } else if (node.left != null && find(node.left, value, sb)) {
            sb.append('L');
        } else if (node.right != null && find(node.right, value, sb)) {
            sb.append('R');
        }
        
        return sb.length() > 0;
    }
}