class UF {
    int[] parent;
    int[] sz;
    double[] weight;
    int count;
    public UF(int n) {
        parent = new int[n];
        sz = new int[n];
        weight = new double[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            sz[i] = 1;
            weight[i] = 1.0;
        }
        count = n;
    }
    public int find(int p) {
        if (p != parent[p]) {
            int origp = parent[p];
            parent[p] = find(parent[p]);
            weight[p] *= weight[origp];
        }
        return parent[p];
    }
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    public double getQuotient(int p, int q) {
        if (connected(p, q))
            return weight[p] / weight[q];
        else
            return -1.0;
    }
    public void union(int p, int q, double value) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        if (sz[rootP] < sz[rootQ]) {
            parent[rootP] = rootQ;
            sz[rootQ] += sz[rootP];
            weight[rootP] = weight[q] * value / weight[p];
        }
        else {
            parent[rootQ] = rootP;
            sz[rootP] += sz[rootQ];
            weight[rootQ] = weight[p] / value / weight[q];
        }
        count--;
    }
}
class Solution {
    private Map<String, Integer> varIndex;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        varIndex = new HashMap<>();
        int M = equations.size();
        int n = M * 2;
        UF uf = new UF(n);
        int id = 0;
        for (int i = 0; i < M; i++) {
            String v1 = equations.get(i).get(0);
            String v2  = equations.get(i).get(1);
            double q = values[i];
            if (!varIndex.containsKey(v1))
                varIndex.put(v1, id++);
            if (!varIndex.containsKey(v2))
                varIndex.put(v2, id++);
            uf.union(indexOf(v1), indexOf(v2), q);
        }

        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String v1 = queries.get(i).get(0);
            String v2 = queries.get(i).get(1);
            if (!varIndex.containsKey(v1) || !varIndex.containsKey(v2))
                ans[i] = -1.0;
            else if (v1.equals(v2))
                ans[i] = 1.0;
            else {
                ans[i] = uf.getQuotient(indexOf(v1), indexOf(v2));
            }
        }
        return ans;
    }
    private Integer indexOf(String name) {
        return varIndex.get(name);
    }
}