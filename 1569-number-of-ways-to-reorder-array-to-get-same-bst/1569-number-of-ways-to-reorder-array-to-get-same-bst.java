class Solution {
   class Node{
        Node left;
        Node right;
        int val;
        Node(int val) {
            this.val = val;
        }
    }
    int[][] memo ;
    long[][] pascal;
    int mod = 1000000007;
    public int numOfWays(int[] nums) {
        // 4! / 2 / 2 = 6 
        // (total permutation )5!/ 3!/ 2! * 2(subTree permutation)
        // -> tree # -1 (root) ! / left #! / right #! * left() * right()
                
        int n = nums.length;
        pascal = new long[n][n];
        buildPascal(n);
        Node root = buildTree(nums); //printTree(root);
        memo = new int[n+1][2];
        
        return helper(root)[0]-1;
    }
    
    void buildPascal(int n) {
        pascal[0][0] = 1L;
        for(int i=1; i<n; i++) {
            for(int j=0; j<=i; j++) {
                if(j==0) pascal[i][j] = pascal[i-1][j];
                else pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
                pascal[i][j] %= mod;
            }
        }
    }
    
    int[] helper(Node node) { //return {ans, node count}
        if(node == null) return new int[]{1, 0};
        if(memo[node.val][0] != 0) return memo[node.val];
        int count = 1;
        
        int[] left = helper(node.left);
        int[] right = helper(node.right);
        
        count += left[1] + right[1];
        long ans = (((pascal[count-1][left[1]]*left[0])%mod)*right[0])%mod;
        memo[node.val] = new int[]{(int)ans, count};
        return new int[]{(int)ans, count};
    }
    
    Node buildTree(int[] nums) {
        Node root =new Node(nums[0]);
        for(int i=1; i<nums.length; i++) {
            Node cur = root;
            while(true) {
                if(nums[i] > cur.val) {
                    if(cur.right == null) {
                        cur.right = new Node(nums[i]);
                        break;
                    } else {
                        cur = cur.right;
                    }
                } else {
                    if(cur.left == null) {
                        cur.left = new Node(nums[i]);
                        break;
                    } else {
                        cur = cur.left;
                    }
                }
            }
        }
        
        return root;
    }
}