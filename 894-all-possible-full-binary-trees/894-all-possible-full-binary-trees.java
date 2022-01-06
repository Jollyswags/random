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
    HashMap<Integer, List<TreeNode>> map=new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> ans=new ArrayList<>();
        if(!map.containsKey(n))
        {
            if(n==1)
            ans.add(new TreeNode(0));
        else
            if(n%2 == 1)
            {
                for(int x=0;x<n;x++)
                {
                    int y=n-1-x;
                    for(TreeNode left: allPossibleFBT(x))
                    {
                        for(TreeNode right: allPossibleFBT(y))
                        {
                            TreeNode bst=new TreeNode(0);
                            bst.left=left;
                            bst.right=right;
                            ans.add(bst);
                        }
                    }
                }
                
            }
            map.put(n,ans);
        }
        return map.get(n);
    }
}