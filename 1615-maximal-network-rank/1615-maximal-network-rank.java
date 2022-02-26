class Solution {

         public int maximalNetworkRank(int n, int[][] roads) {
         int[] degreeOfNodes = new int[n];
    for (int[] road : roads) {
      degreeOfNodes[road[0]]++;
      degreeOfNodes[road[1]]++;
    }
    int maxDegree1 = 0, maxDegree2 = 0;
    for (int node = 0; node < n; ++node) {//get first and second max
      int degreeOfNode = degreeOfNodes[node];
      if (degreeOfNode > maxDegree1) {
        maxDegree2 = maxDegree1;
        maxDegree1 = degreeOfNode;
      } else if (degreeOfNode < maxDegree1 && degreeOfNode > maxDegree2){
        maxDegree2 = degreeOfNode;
      }
    }
    int nRoadMaxDegree = 0, nRoadCrossDegree = 0;
    for (int[] road : roads) {
      int degree1 = degreeOfNodes[road[0]];
      int degree2 = degreeOfNodes[road[1]];
      if (degree1 == maxDegree1 && degree2 == maxDegree1) {
        nRoadMaxDegree++;
      } else if (degree1 == maxDegree1 && degree2 == maxDegree2 ||
        degree1 == maxDegree2 && degree2 == maxDegree1) {
        nRoadCrossDegree++;
      }
    }
    int nNodeOfMaxDegree1 = 0, nNodeOfMaxDegree2 = 0;
    for (int node = 0; node < n; ++node) {
      int degree = degreeOfNodes[node];
      if (degree == maxDegree1) {
        nNodeOfMaxDegree1++;
      } else if (degree == maxDegree2) {
        nNodeOfMaxDegree2++;
      }
    }
    int maxRank = 0;
    if (nNodeOfMaxDegree1 > 1) {
      if (nRoadMaxDegree >= nNodeOfMaxDegree1 * (nNodeOfMaxDegree1 - 1) / 2) {
        maxRank = Math.max(maxRank, maxDegree1 * 2 - 1);
      } else {
        maxRank = Math.max(maxRank, maxDegree1 * 2);
      }
    }
    if (nNodeOfMaxDegree1 > 0 && nNodeOfMaxDegree2 > 0) {
      if (nRoadCrossDegree >= nNodeOfMaxDegree1 * nNodeOfMaxDegree2) {
        maxRank = Math.max(maxRank, maxDegree1 + maxDegree2 - 1);
      } else {
        maxRank = Math.max(maxRank, maxDegree1 + maxDegree2);
      }
    }
    return maxRank;
    }
}
//O(1)