class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
          
        List<List<Integer>>result = new ArrayList<>();
        PriorityQueue<List<Integer>>pq=new PriorityQueue<>((a,b)->
                                                           ((b.get(0)+b.get(1))-(a.get(0)+a.get(1)))
                                                          );
        //The priority Q stores iterates through nums1 and nums2 and stores k combinations in a max heap
        //when the size excees k, we pop the max element.
        
        /*****************/
        //This part is written to reduce the iteration calls and bypass the TLE error.
        int x=0;
        if(nums1.length<k)    //reduce the iterations for nums1 to atmost k
            x=nums1.length;
        else x=k;
        int y=0;
        if(nums2.length<k)     //reduce the iterations for nums2 to atmost k
            y=nums2.length;
        else y=k;
        /*****************/
        
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                pq.add(Arrays.asList(nums1[i],nums2[j]));
                if(pq.size()>k)
                        pq.poll(); 
            }
        }
        
        while(pq.peek()!=null){
            if(k<1)
                break;
            else{
                result.add(pq.poll());
            }
                k--;
        }
        return result;
    }
}