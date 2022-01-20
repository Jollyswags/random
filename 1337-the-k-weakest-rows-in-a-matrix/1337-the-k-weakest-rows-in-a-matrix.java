/**
 * Using Binary Search + PriorityQueue (Max Heap)
 *
 * Find the left most zero in each row (using binary search). Save the row index
 * and count combination in max heap of size k.
 *
 * Time Complexity:
 * O(M * logN) --> To find the left most zero in each row
 * O(M * logK) --> To add and poll from PriorityQueue. K elements are maintained in the queue.
 * Total Time Complexity: O(M * log(NK))
 *
 * Space Complexity: O(K) --> Used by MaxHeap
 *
 * M = Number of rows. N = Number of Columns.
 */
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        if (mat == null || k < 0 || mat.length < k) {
            throw new IllegalArgumentException("Input is invalid");
        }

        // Max Heap
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[1] != b[1] ? b[1] - a[1] : b[0] - a[0]));

        for (int i = 0; i < mat.length; i++) {
            queue.offer(new int[] { i, getSoldierCount(mat[i]) });
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[] result = new int[k];
        while (!queue.isEmpty()) {
            result[--k] = queue.poll()[0];
        }
        return result;
    }

    private int getSoldierCount(int[] row) {
        if (row[0] == 0) {
            return 0;
        }
        if (row[row.length - 1] == 1) {
            return row.length;
        }
        int start = 0;
        int end = row.length; // Number of solder can be maximum row.length. Thus end needs to be row.length

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (row[mid] == 1) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end;
    }
}