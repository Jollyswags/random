class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
	

	Map<Integer, Integer> parent = new HashMap<>();

	for (int[] edge : edges) {
		if (parent.containsKey(edge[1])) parent.put(edge[0], edge[1]);    
		else parent.put(edge[1], edge[0]);     
	}

	Set<Integer> visited = new HashSet<>();
	int total = 0;

	for (int i = 0; i < n; i++) {
		if (hasApple.get(i)) {
			total += pathToRoot(parent, i, visited);
		}
	}
	return total;
}

private int pathToRoot(Map<Integer, Integer> parent, int node, Set<Integer> visited) {
	int count = 0;

	while (node != 0 && !visited.contains(node)) {
		visited.add(node);
		node = parent.get(node);
		count += 2;
	}
	return count;
}
}