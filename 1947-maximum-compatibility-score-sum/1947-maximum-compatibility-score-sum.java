class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        return helper(0, students, mentors, new HashSet<>(), new HashMap<>());
    }
    
    public int helper(int idx, int[][] students, int[][] mentors, Set<Integer> set, Map<Pair<Integer, String>, Integer> dp){
        if(idx==students.length){
            return 0;
        }
        
        Pair<Integer, String> key = new Pair<>(idx, set.toString());
        if(dp.containsKey(key)) return dp.get(key);
        
        int ans = 0;
        for(int i=0; i<mentors.length; i++){
            if(set.contains(i)) continue;
            
            int[] mentor = mentors[i];
            int[] student = students[idx];
            set.add(i);
            ans = Math.max(ans, compatibility(mentor, student) + helper(idx+1, students, mentors, set, dp));
            set.remove(i);
        }
        
        dp.put(key, ans);
        return ans;
    }
    
    public int compatibility(int[] arr1, int[] arr2){
        int n = arr1.length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(arr1[i] == arr2[i]) ans++;
        }
        return ans;
    }
}