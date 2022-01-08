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
    int maxfreq=Integer.MIN_VALUE;
    HashMap<Integer,Integer> map=new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        postorder(root);
        List<Integer> ans=new ArrayList<>();
        for(int i:map.keySet())
        {
            if(maxfreq==map.get(i))
                ans.add(i);
        }
        int res[]=new int[ans.size()];
        int j=0;
        for(int i:ans)
            res[j++]=i;
        return res;
            
    }
    public int postorder(TreeNode root)
    {
        if(root==null)
            return 0;
      int left=  postorder(root.left);
      int right=  postorder(root.right);
        int sum=root.val + left + right;
        map.put(sum,map.getOrDefault(sum,0)+1);
        maxfreq=Math.max(maxfreq,+map.get(sum));   
        return sum;
    }
}