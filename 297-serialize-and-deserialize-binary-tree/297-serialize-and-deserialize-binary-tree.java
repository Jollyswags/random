/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

 // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        preorder(root, result);
        result.deleteCharAt(result.length() - 1);
        
        return result.toString();
    }
    
    private void preorder(TreeNode node, StringBuilder curr) {
        // base case
        if(node == null) {
            curr.append('N');
            curr.append('.');
            return;
        }
        
        curr.append(node.val);
        curr.append('.');
        
        preorder(node.left, curr);
        preorder(node.right, curr);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strVals = data.split("\\.");
        
        TreeNode root = helper(strVals);
        return root;
    }
    
    int idx = 0;
    private TreeNode helper(String[] strVals) {
        // base case
        String curr = strVals[idx];
        if(curr.equals("N")) {
            idx++;
            return null;
        } else {
            int num = Integer.valueOf(curr);
            TreeNode node = new TreeNode(num);
            idx++;
            node.left = helper(strVals);
            node.right = helper(strVals);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));