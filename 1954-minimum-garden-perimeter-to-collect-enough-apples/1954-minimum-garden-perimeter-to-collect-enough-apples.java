class Solution {
     public long calculateTotalApples(long n) {
        // apples on 1 axis: n*(n+1)/2; (1,0), (2,0), (3, 0),...
        // apples in 1st quadrant except on axes–
        //      n lines parallel to x-axis: n * (n*(n+1)/2); [(1,y), (2,y),...] x n
        //      n lines parallel to y-axis: n * (n*(n+1)/2); [(x,1), (x,2),...] x n
        //                   total: 2 * n*(n*(n+1)/2)
        long ans = (n*(n+1)/2) * (1 + 2*n);
        return 4*ans;   // total number of quadrants = 4
    }

    /**
     * <strong>Binary search</strong> the number of sides length of the plot
     * @param neededApples number of apples required in the plot (including on perimeter)
     * @return the minimum perimeter of a plot such that at least {@code neededApples} apples are inside or on the perimeter of that plot.
     */
    public long minimumPerimeter(long neededApples) {
        long l = 1, r = (long) 1e5;
        while(l < r) {
            long mid = l + (r-l)/2;
            // if total number of apples in plot of side length (2 * mid)
            // is less than neededApples then size of plot must be higher than mid
            if (calculateTotalApples(mid) < neededApples) {
                l = mid+1;
            }
            else {
                r = mid;
            }
        }
        return 8*r;     // perimeter is 8 times of a half-part in 1st quadrant
    }
}