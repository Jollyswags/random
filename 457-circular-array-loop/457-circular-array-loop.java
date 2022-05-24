class Solution {
    public boolean circularArrayLoop(int[] nums) {
        // record elements showed in all loops
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i <= nums.length - 1; i++){
            // jump elements tested before
            if(set.contains(i)) continue;
            
            // record elements showed in the current loop
            Set<Integer> cset = new HashSet<>();
            
            // record the previous index. 
            int index = i, prev = i - 1;
            while(nums[i] * nums[index] > 0){
				// If the previous index is same as the current index, return false. Because the sequence's length must be greater than 1 to be a cycle.
                if(index == prev) break;
                else prev = index;

                //if the element show twice in the loop, it's cycle.
                if(cset.contains(index)) return true;
                else cset.add(index);

                //covert new index to the valid range
                index += nums[index];
                index = index % nums.length;
                if(index < 0) index += nums.length;
            }
            
			set.addAll(cset);
            if(set.size() == nums.length) return false;
        }
        
        return false;
    }
}