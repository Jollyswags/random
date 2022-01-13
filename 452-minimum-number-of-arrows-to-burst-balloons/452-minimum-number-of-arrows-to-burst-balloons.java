class Solution {
   public int findMinArrowShots(int[][] points) {
		Arrays.sort(points, (p1,p2) -> Integer.compare(p1[0],p2[0]));
		int arrow = 1;
		int index =1;
		int[] lastIntersection= new int[]{points[0][0],points[0][1]};
		/**
		 * If you see lastIntersection here , we are actually not using lastIntersection[0] anywhere
		 * so we can easily replace the above array to a variable that stores only last index of intersection
		 * and the solution will work just fine.
		 * */
		while(index <points.length){
		// Not intersecting case
			if(lastIntersection[1] < points[index][0]){
				lastIntersection[0] = points[index][0];
				lastIntersection[1] = points[index][1];
				arrow++;
			}else{ // Intersecting case
				lastIntersection[0] = Math.max(lastIntersection[0], points[index][0]);
				lastIntersection[1] = Math.min(lastIntersection[1], points[index][1]);

			}
			index++;
		}
		return arrow;
	}
}