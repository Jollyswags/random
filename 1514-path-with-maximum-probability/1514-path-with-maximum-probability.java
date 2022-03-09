class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
		// Create the graph(adjacency list)
        Map<Integer, List<Dest>> graph = new HashMap<>();
        for(int i = 0; i < edges.length; i++) {
            graph.putIfAbsent(edges[i][0], new ArrayList<>());
            graph.get(edges[i][0]).add(new Dest(edges[i][1], succProb[i]));
            graph.putIfAbsent(edges[i][1], new ArrayList<>());
            graph.get(edges[i][1]).add(new Dest(edges[i][0], succProb[i]));
        }
		
        PriorityQueue<Dest> pq = new PriorityQueue<>(new Comparator<Dest>() {
			public int compare(Dest a, Dest b) {
                if(a.prob > b.prob) return -1;
                else return 1;
            }
        });
        
        boolean[] visited = new boolean[n];
        pq.offer(new Dest(start, 1.0));
        
        while(!pq.isEmpty()) {
            Dest d = pq.poll();
            int currNode = d.dest;
            if(visited[currNode]) {
                continue;
            }
            visited[currNode] = true;
            double currDist = d.prob;
            if(currNode == end) { 
			// Return if this is the end node
                return currDist;
            }
            
            // Traverse the source to put all the edges in the graph
             if(graph.containsKey(currNode)) {
                for(Dest t : graph.get(currNode)) {
                    if(!visited[t.dest]) {
                        pq.offer(new Dest(t.dest, currDist * t.prob));
                    }
                }
            }
        }
        // If we reached here that means the end is unreachable by other nodes so return 0
        return 0;
    }
    
    class Dest {
        int dest;
        double prob;
        public Dest(int dest, double prob) {
            this.dest = dest;
            this.prob = prob;
        }
    }
}