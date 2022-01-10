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
    class Point {
        int x;
        int y;
        int val;
        public Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        PriorityQueue<Point> pq = new PriorityQueue<>(1000, new Comparator<Point>() {
            public int compare(Point p1, Point p2) {
                if (p1.x < p2.x) return -1;
                if (p2.x < p1.x) return 1;
                if (p1.y < p2.y) return -1;
                if (p2.y < p1.y) return 1;
                return p1.val - p2.val;
            }
        });
        helper(root, 0, 0, pq);
        int x = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        while(!pq.isEmpty()){
            Point p = pq.poll();
            // System.out.println(p.val + " " + p.x + " " + p.y);
            if (x != Integer.MIN_VALUE && p.x != x) {
                result.add(list);
                list = new ArrayList<>();
            }
            list.add(p.val);
            x = p.x;
        }
        
        result.add(list);
        return result;
    }
    
    private void helper(TreeNode root, int x, int y, PriorityQueue<Point> pq) {
        if (root == null) {
            return;
        }
        pq.offer(new Point(x, y, root.val));
        helper(root.left, x - 1, y + 1, pq);
        helper(root.right, x + 1, y + 1, pq);
    }
}