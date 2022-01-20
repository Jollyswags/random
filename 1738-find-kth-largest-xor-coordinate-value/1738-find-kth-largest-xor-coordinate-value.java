class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
var minHeap = new PriorityQueue<Integer>(k);
	var prefixXor = new int[matrix.length + 1][matrix[0].length + 1];
	for (var i = 1; i < prefixXor.length; i++)
		for (var j = 1; j < prefixXor[0].length; j++) {
			prefixXor[i][j] = matrix[i - 1][j - 1]
					^ prefixXor[i - 1][j]
					^ prefixXor[i][j - 1]
					^ prefixXor[i - 1][j - 1];
			minHeap.add(prefixXor[i][j]);
			if (minHeap.size() > k)
				minHeap.poll();
		}
	return minHeap.peek();
    }
}