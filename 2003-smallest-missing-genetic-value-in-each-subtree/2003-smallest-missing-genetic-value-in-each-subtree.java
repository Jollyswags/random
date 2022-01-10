class Solution {
    HashMap<Integer, List<Integer>> m = new HashMap<>();
    //int[] A;
    int miss = 1;
    HashSet<Integer> set = new HashSet<>();

    public int[] smallestMissingValueSubtree(int[] parent, int[] nums) {

        int n = parent.length;
        //A = nums;
        for (int i = 0; i < n; i++) {
            m.computeIfAbsent(parent[i], k->new ArrayList<>()).add(i);
        }
        int[] res = new int[n];
        Arrays.fill(res, 1);
        int idx = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                idx = i;
                break;
            }
        }
        if (idx == -1) return res;
        int s = idx;
        int pre = -1; // pre handled node
        while (s != -1) {
            List<Integer> list = m.get(s);
            if (list != null) {
                for (int j : m.get(s)) {
                    if (j == pre)  continue; // skip handled
                    dfs(j, nums);
                }
            }
            set.add(nums[s]);
            while (set.contains(miss)) {
                miss++;
            }
            res[s] = miss;

            pre = s; // update pre and s
            s = parent[s]; // path from 1 up to root

        }
        return res;
    }

    void dfs(int i, int[] nums) {
        set.add(nums[i]);
        List<Integer> list = m.get(i);
        if (list == null) return;
        for (int j : list) {
            dfs(j, nums);
        }
    }
}