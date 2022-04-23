class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0])); 
        LinkedList<int[]>list=new LinkedList<>();
        for(int in[]:intervals)
        {
            if(list.isEmpty() || list.getLast()[1]<in[0])
                list.add(in);
            else
                list.getLast()[1]=Math.max(list.getLast()[1],in[1]);
        }
        return list.toArray(new int[list.size()][]);
    }
}
//nlogn
//n