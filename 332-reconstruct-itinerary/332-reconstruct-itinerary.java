class Solution {
      HashMap<String, LinkedList<String>> flightMap = new HashMap<>();
  LinkedList<String> result = null;

  public List<String> findItinerary(List<List<String>> tickets) {
    // Step 1). build the graph first
    for(List<String> ticket : tickets) {
      String origin = ticket.get(0);
      String dest = ticket.get(1);
      if (flightMap.containsKey(origin)) {
        LinkedList<String> destList = this.flightMap.get(origin);
        destList.add(dest);
      } else {
        LinkedList<String> destList = new LinkedList<String>();
        destList.add(dest);
        flightMap.put(origin, destList);
      }
    }

    // Step 2). order the destinations
    flightMap.forEach((key, value) -> Collections.sort(value));

    result = new LinkedList<String>();
    // Step 3). post-order DFS
    DFS("JFK");
    return result;
  }

  protected void DFS(String origin) {
    // Visit all the outgoing edges first.
    if (flightMap.containsKey(origin)) {
      LinkedList<String> destList = this.flightMap.get(origin);
      while (!destList.isEmpty()) {
        // while we visit the edge, we trim it off from graph.
        String dest = destList.pollFirst();
        DFS(dest);
      }
    }
    // add the airport to the head of the itinerary
    result.offerFirst(origin);
  }
}