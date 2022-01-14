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
        StringBuilder result=new StringBuilder();
        preorder(root,result);
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }
    public void preorder(TreeNode root, StringBuilder curr)
    {
        if(root==null)
        {
            curr.append('N');
            curr.append('.');
            return;
        }
        curr.append(root.val);
        curr.append('.');
        preorder(root.left,curr);
        preorder(root.right,curr);
    }
int idx=0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strvals=data.split("\\.");
        TreeNode root=helper(strvals);
        return root;
    }
    public TreeNode helper(String[] strvals)
    {
        String curr=strvals[idx];
        if(curr.equals("N"))
        {
            idx++;
            return null;
        }
        int nums=Integer.parseInt(curr);
        TreeNode root=new TreeNode(nums);
        idx++;
        root.left=helper(strvals);
        root.right=helper(strvals);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));