class Solution {
    public int minSetSize(int[] arr) {
     PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
       int n= arr.length,remnum=0,count=0; 
        
       Map<Integer,Integer> map= new HashMap(); 
        
       for(int i:arr){
           map.put(i,map.getOrDefault(i,0)+1);
       } 
        
      for(int j:map.values()){
          pq.offer(j);
      }  
        
     while(remnum < n/2){
         remnum+=pq.poll();
         count++;
     }
        
        
        return count;
    }
}