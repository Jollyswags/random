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
class FindElements {

     HashSet<Integer> set=new HashSet<>();
    TreeNode root;
    public FindElements(TreeNode root) {
        this.root=root;
        recover(root,0);
    }
    public void recover(TreeNode root, int x)
    {
      if(root!=null)
      {
        root.val=x;
        set.add(x);
        recover(root.left,x*2 + 1);
        recover(root.right, x*2 +2);
      }
    }
    
    
    public boolean find(int target) {
       return set.contains(target); 
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */