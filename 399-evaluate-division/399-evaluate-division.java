class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Creating the parent graph.
        Map<String, Pair<String, Double>> parent = new HashMap<>();
        Map<String, Integer> size = new HashMap<>();
        for (List<String> equation: equations) {
            String s1 = equation.get(0);
            String s2 = equation.get(1);
            parent.putIfAbsent(s1, new Pair<>(s1, 1.0));
            parent.putIfAbsent(s2, new Pair<>(s2, 1.0));
            size.putIfAbsent(s1, 1);
            size.putIfAbsent(s2, 1);
        }
        
        for (int i = 0; i < equations.size(); i++) {
            String s1 = equations.get(i).get(0);
            String s2 = equations.get(i).get(1);
            double value = values[i];
            union(s1, s2, value, parent, size);
        }

        // Main loop
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String s1 = query.get(0);
            String s2 = query.get(1);
            if (!parent.containsKey(s1) || !parent.containsKey(s2)) {
                ans[i] = -1.0;
                continue;
            }
            if (s1.equals(s2)) {
                ans[i] = 1.0;
                continue;
            }
            String p1 = find(s1, parent).getKey();
            String p2 = find(s2, parent).getKey();
            if (!p1.equals(p2)) {
                ans[i] = -1.0;
            } else {
                ans[i] = find(s1, parent).getValue() / find(s2, parent).getValue();
            }
        }
        
        return ans;
    }
    
    public Pair<String, Double> find(String p, Map<String, Pair<String, Double>> parent) {
        String key = parent.get(p).getKey();
        String keyP = parent.get(key).getKey();
        while (!key.equals(keyP)) {
            double value = parent.get(p).getValue();
            double valueP = parent.get(key).getValue();
            parent.put(p, new Pair<>(keyP, value * valueP));
            key = parent.get(p).getKey();
            keyP = parent.get(key).getKey();
        }
        return parent.get(p);
    }
    
    public void union(String s1, String s2, double value, Map<String, Pair<String, Double>> parent, Map<String, Integer> size) {
        Pair<String, Double> p1 = find(s1, parent);
        Pair<String, Double> p2 = find(s2, parent);
        String node1 = p1.getKey();
        String node2 = p2.getKey();
        double ratio1 = p1.getValue();
        double ratio2 = p2.getValue();
        int size1 = size.get(node1);
        int size2 = size.get(node2);
        if (node1.equals(node2)) return;
        if (size1 >= size2) {
            parent.put(node2, new Pair<>(node1, ratio1 / (ratio2 * value)));
            size.put(node1, size1 + size2);
        } else {
            parent.put(node1, new Pair<>(node2, ratio2 * value / ratio1));
            size.put(node2, size1 + size2);
        }
    }
}