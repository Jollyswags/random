class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        char[] result = new char[n];
    	int[] roots = new int[n], ranks = new int[n];
    	for (int i = 0; i < n; i++) {
    		roots[i] = i;
    		ranks[i] = 1;
    	}
    	for (List<Integer> p : pairs)
    		union(roots, ranks, p.get(0), p.get(1));
        Map<Integer, int[]> map = new HashMap<>();
    	for (int i = 0; i < n; i++)
    		map.computeIfAbsent(find(roots, i), x -> new int[26])[s.charAt(i) - 'a']++;
    	for (int i = 0; i < n; i++) {
    		int[] array = map.get(find(roots, i));
    		for (int j = 0; j < 26; j++)
    			if (array[j] != 0) {
    				result[i] = (char)('a' + j);
    				array[j]--;
    				break;
    			}
    	}
    	return String.valueOf(result);
    }
    int find(int[] roots, int x) {
    	if (x == roots[x])
    		return x;
    	return roots[x] = find(roots, roots[x]);
    }
    void union(int[] roots, int[] ranks, int x, int y) {
    	int rootX = find(roots, x), rootY = find(roots, y);
    	if (rootX != rootY)
    		if (ranks[rootX] == ranks[rootY]) {
    			roots[rootY] = rootX;
    			ranks[rootX]++;
    		} else if (ranks[rootX] > ranks[rootY])
    			roots[rootY] = rootX;
    		else
    			roots[rootX] = rootY;
    }
}