class Solution {
    public int[][] reconstructQueue(int[][] people) {
         Arrays.sort(people,new Comparator<int[]>() {
       public int compare(int[]a, int[]b){
           return a[0]!=b[0]?-a[0]+b[0]:a[1]-b[1];
       } 
     }
        );
       List<int[]> res = new ArrayList<>();
       for(int[] a:people){
           res.add(a[1], a);
       } 
        return res.toArray(new int[people.length][]);
    }
}