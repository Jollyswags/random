class Solution {
 protected void backtrack(
            int remain,
            LinkedList<Integer> comb,
            int start, int[] candidates,
            List<List<Integer>> results) {

        if (remain == 0) {
            // make a deep copy of the current combination
            results.add(new ArrayList<Integer>(comb));
            return;
        } else if (remain < 0) {
            // exceed the scope, stop exploration.
            return;
        }

        for (int i = start; i < candidates.length; ++i) {
            // add the number into the combination
            comb.add(candidates[i]);
            this.backtrack(remain - candidates[i], comb, i, candidates, results);
            // backtrack, remove the number from the combination
            comb.removeLast();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        LinkedList<Integer> comb = new LinkedList<Integer>();

        this.backtrack(target, comb, 0, candidates, results);
        return results;
    }
}
/*Complexity Analysis

Let NN be the number of candidates, TT be the target value, and MM be the minimal value among the candidates.

Time Complexity: \mathcal{O}(N^{\frac{T}{M}+1})
 )

As we illustrated before, the execution of the backtracking is unfolded as a DFS traversal in a n-ary tree. The total number of steps during the backtracking would be the number of nodes in the tree.

At each node, it takes a constant time to process, except the leaf nodes which could take a linear time to make a copy of combination. So we can say that the time complexity is linear to the number of nodes of the execution tree.

Here we provide a loose upper bound on the number of nodes.

First of all, the fan-out of each node would be bounded to NN, i.e. the total number of candidates.

The maximal depth of the tree, would be \frac{T}{M}, where we keep on adding the smallest element to the combination.

As we know, the maximal number of nodes in N-ary tree of \frac{T}{M} 

  height would be N^{\frac{T}{M}+1}

Note that, the actual number of nodes in the execution tree would be much smaller than the upper bound, since the fan-out of the nodes are decreasing level by level.

Space Complexity: \mathcal{O}(\frac{T}{M})
We implement the algorithm in recursion, which consumes some additional memory in the function call stack.

The number of recursive calls can pile up to \frac{T}{M} 

 , where we keep on adding the smallest element to the combination. As a result, the space overhead of the recursion is \mathcal{O}(\frac{T}{M})

In addition, we keep a combination of numbers during the execution, which requires at most \mathcal{O}(\frac{T}{M}) space as well.

To sum up, the total space complexity of the algorithm would be \mathcal{O}(\frac{T}{M})

Note that, we did not take into the account the space used to hold the final results for the space complexity*/