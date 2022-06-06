class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
          Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        Queue<Integer> q = new LinkedList<>();
        for (Integer key : map.keySet()) {
            if (!map.containsKey(key - 1)) {
                q.offer(key);
            }
        }
        
        int count = 0;
        while (!q.isEmpty()) {
            int start = q.poll();
            for (int i = start; i < start + k; i++) {
                int rest = map.getOrDefault(i, 0);
                if (rest == 0) {
                    return false;
                }
                count++;
                map.put(i, rest - 1);
                if (map.get(i) == 0) {
                    map.remove(i);
                }
                else {
                    if (!map.containsKey(i - 1)) {
                        q.offer(i);
                    }    
                }
            }
            if (map.containsKey(start + k) && !map.containsKey(start + k - 1)) {
                q.offer(start + k);
            }
        }
        return count == nums.length;
    }
}