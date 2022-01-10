class Solution {
   public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int[] res = new int[nums.length];
        
        // put all the children nodes in an array to travel down.
        List<Integer>[] children = new List[nums.length];
        // find Idx of Node1 at the same time
        int node1Idx = -1;
        // we skip the root node as its parent is -1.
        for (int i = 1; i < parents.length; ++i) {
            if (children[parents[i]] == null) {
                children[parents[i]] = new ArrayList<>();
            }
            children[parents[i]].add(i);
            if (nums[i] == 1) {
                node1Idx = i;
            }
        }
        // Don't forget the root node can be 1 as well
        if (nums[0] == 1) {
            node1Idx = 0;
        }
        // If no Node1.all the smallest genetic value should be 1
        if (node1Idx < 0) {
            Arrays.fill(res, 1);
            return res;
        }
        // set to record node value
        Set<Integer> visited = new HashSet<>();
        
        recur(children, node1Idx, parents, nums, res, visited, 1, -1);
        return res;
        
        
    }
    
    private void recur(List<Integer>[] children, int id, int[] parents, int[] nums, int[] res, Set<Integer> visited, int min, int stop) {
        // becaues it is needed traverse up in later stage. A stop mark should make sure it only travel within the subtree
        if (id == stop) {
            return;
        }
        // for all the branches, they should be step to 1.
        if (children[id] != null) {
            for (int i : children[id]) {
                if (res[i] > 0) {
                    continue;
                }
				// if it is not on the path from Node1 to root, it should be set to 1.
                res[i] = 1;
                visited.add(nums[i]);
				// same here. the smallest generic value should be 1
                recur(children, i, parents, nums, res, visited, 1, id);
            }
        }
        // check if the min is still the small value. if the current value is min or min is in the subtree, it would be increased until a unseen min is met.
        while (nums[id] == min || visited.contains(min)) {
            min++;
        }
        // 1 would not be added in the set as nodes of sibling branches of Node 1 would be set to 1. 
        if (nums[id] > 1) {
            visited.add(nums[id]);
        }
        res[id] = min;
        recur(children, parents[id], parents, nums, res, visited, min, stop);
    }
}