class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        while (m < n) {
      // turn off rightmost 1-bit
      n = n & (n - 1);
    }
    return m & n;
    }
}
/*Time Complexity:O(1).

Similar as the bit shift approach, the number of iteration in the algorithm is bounded by the number of bits in an integer number, which is constant.

Though having the same asymptotic complexity as the bit shift approach, the Brian Kernighan's algorithm requires less iterations, since it skips all the zero bits in between.

Space Complexity: O(1), since no additional memory is consumed by the algorithm.
*/