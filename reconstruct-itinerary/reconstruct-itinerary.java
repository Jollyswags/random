class Solution {
  // origin -> list of destinations
  HashMap<String, LinkedList<String>> flightMap = new HashMap<>();
  LinkedList<String> result = null;

  public List<String> findItinerary(List<List<String>> tickets) {
    // Step 1). build the graph first
    for(List<String> ticket : tickets) {
      String origin = ticket.get(0);
      String dest = ticket.get(1);
      if (this.flightMap.containsKey(origin)) {
        LinkedList<String> destList = this.flightMap.get(origin);
        destList.add(dest);
      } else {
        LinkedList<String> destList = new LinkedList<String>();
        destList.add(dest);
        this.flightMap.put(origin, destList);
      }
    }

    // Step 2). order the destinations
    this.flightMap.forEach((key, value) -> Collections.sort(value));

    this.result = new LinkedList<String>();
    // Step 3). post-order DFS
    this.DFS("JFK");
    return this.result;
  }

  protected void DFS(String origin) {
    // Visit all the outgoing edges first.
    if (this.flightMap.containsKey(origin)) {
      LinkedList<String> destList = this.flightMap.get(origin);
      while (!destList.isEmpty()) {
        // while we visit the edge, we trim it off from graph.
        String dest = destList.pollFirst();
        DFS(dest);
      }
    }
    // add the airport to the head of the itinerary
    this.result.offerFirst(origin);
  }
}
/*Eulerian Cycle

In graph theory, an Eulerian trail (or Eulerian path) is a trail in a finite graph that visits every edge exactly once (allowing for revisiting vertices).

In our problem, we are asked to construct an itinerary that uses all the flights (edges), starting from the airport of "JFK". As one can see, the problem is actually a variant of Eulerian path, with a fixed starting point.

Similarly, an Eulerian circuit or Eulerian cycle is an Eulerian trail that starts and ends on the same vertex.

The Eulerian cycle problem has been discussed by Leonhard Euler back in 1736. Ever since, there have been several algorithms proposed to solve the problem.

In 1873, Hierholzer proposed an efficient algorithm to find the Eulerian cycle in linear time (\mathcal{O}(|E|)O(∣E∣)). One could find more details about the Hierholzer's algorithm in this course.

The basic idea of Hierholzer's algorithm is the stepwise construction of the Eulerian cycle by connecting disjunctive circles.

To be more specific, the algorithm consists of two steps:

It starts with a random node and then follows an arbitrary unvisited edge to a neighbor. This step is repeated until one returns to the starting node. This yields a first circle in the graph.

If this circle covers all nodes it is an Eulerian cycle and the algorithm is finished. Otherwise, one chooses another node among the cycles' nodes with unvisited edges and constructs another circle, called subtour.

pic

By connecting all the circles in the above process, we build the Eulerian cycle at the end.

Eulerian Path

To find the Eulerian path, inspired from the original Hierzolher's algorithm, we simply change one condition of loop, rather than stopping at the starting point, we stop at the vertex where we do not have any unvisited edges.

To summarize, the main idea to find the Eulerian path consists of two steps:

Step 1). Starting from any vertex, we keep following the unused edges until we get stuck at certain vertex where we have no more unvisited outgoing edges.

Step 2). We then backtrack to the nearest neighbor vertex in the current path that has unused edges and we repeat the process until all the edges have been used.

The first vertex that we got stuck at would be the end point of our Eulerian path. So if we follow all the stuck points backwards, we could reconstruct the Eulerian path at the end.

Algorithm

Now let us get back to our itinerary reconstruction problem. As we know now, it is a problem of Eulerian path, except that we have a fixed starting point.

More importantly, as stated in the problem, the given input is guaranteed to have a solution. So we have one less issue to consider.

As a result, our final algorithm is a bit simpler than the above Eulerian path algorithm, without the backtracking step.

The essential step is that starting from the fixed starting vertex (airport 'JFK'), we keep following the ordered and unused edges (flights) until we get stuck at certain vertex where we have no more unvisited outgoing edges.

The point that we got stuck would be the last airport that we visit. And then we follow the visited vertex (airport) backwards, we would obtain the final itinerary.

Here are some sample implementations which are inspired from a thread of discussion in the forum.Discussion

To better understand the above algorithm, we could look at it from another perspective.

Actually, we could consider the algorithm as the postorder DFS (Depth-First Search) in a directed graph, from a fixed starting point.

As we know that, each input is guaranteed to have a solution. Therefore, the task of the problem can be interpreted as that given a list of flights (i.e. edges in graph), we should find an order to use each flight once and only once.

In the resulted path, before we visit the last airport (denoted as V), we can say that we have already used all the rest flights, i.e. if there is any flight starting from V, then we must have already taken that before.

Or to put it another way, before adding the last airport (vertex) in the final path, we have visited all its outgoing vertex.

Actually, the above statement applies to each airport in the final itinerary. Before adding an airport into the final itinerary, we must first visit all its outgoing neighbor vertex.

If we consider the outgoing vertex in a directed graph as children nodes in a tree, one could see the reason why we could consider the algorithm as a sort of postorder DFS traversal in a tree.Complexity

Time Complexity: \mathcal{O}(|E| \log{\frac{|E|}{|V|}})O(∣E∣log 
∣V∣
∣E∣
​
 ) where |E|∣E∣ is the number of edges (flights) in the input.

As one can see from the above algorithm, during the DFS process, we would traverse each edge once. Therefore, the complexity of the DFS function would be |E|∣E∣.

However, before the DFS, we need to sort the outgoing edges for each vertex. And this, unfortunately, dominates the overall complexity.

It is though tricky to estimate the complexity of sorting, which depends on the structure of the input graph.

In the worst case where the graph is not balanced, i.e. the connections are concentered in a single airport. Imagine the graph is of star shape, in this case, the JFK airport would assume half of the flights (since we still need the return flight). As a result, the sorting operation on this airport would be exceptionally expensive, i.e. N \log{N}NlogN, where N = \frac{|E|}{2}N= 
2
∣E∣
​
 . And this would be the final complexity as well, since it dominates the rest of the calculation.

Let us consider a less bad case, or an average case, where the graph is less clustered, i.e. each node has the equal number of outgoing flights. Under this assumption, each airport would have \frac{|E|}{(2\cdot|V|)} 
(2⋅∣V∣)
∣E∣
​
  number of flights (still we need the return flights). Again, we can plug it into the N \log NNlogN minimal sorting complexity. In addition, this time, we need to take into consideration all airports, rather than the superhub (JFK) in the above case. As a result, we have |V| \cdot (N \log N)∣V∣⋅(NlogN), where N = \frac{|E|}{2\cdot|V|}N= 
2⋅∣V∣
∣E∣
​
 . If we expand the formula, we will obtain the complexity of the average case as \mathcal{O}(\frac{|E|}{2} \log{\frac{|E|}{2\cdot|V|}}) = \mathcal{O}(|E| \log{\frac{|E|}{|V|}})O( 
2
∣E∣
​
 log 
2⋅∣V∣
∣E∣
​
 )=O(∣E∣log 
∣V∣
∣E∣
​
 )

Space Complexity: \mathcal{O}(|V| + |E|)O(∣V∣+∣E∣) where |V|∣V∣ is the number of airports and |E|∣E∣ is the number of flights.

In the algorithm, we use the graph, which would require the space of |V| + |E|∣V∣+∣E∣.

Since we applied recursion in the algorithm, which would incur additional memory consumption in the function call stack. The maximum depth of the recursion would be exactly the number of flights in the input, i.e. |E|∣E∣.

As a result, the total space complexity of the algorithm would be \mathcal{O}(|V| + 2\cdot|E|) = \mathcal{O}(|V| + |E|)O(∣V∣+2⋅∣E∣)=O(∣V∣+∣E∣).*/