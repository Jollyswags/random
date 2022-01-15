class Solution {
     public int minJumps(int[] arr) {
        int n=0;
        
        if(arr.length==1)
            return 0;
        
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<arr.length;i++)
            map.computeIfAbsent(arr[i],list -> new ArrayList<>()).add(i);//if the arr[i] isnt present in map add it with new array list else just add the new index to it
        
        Queue<Integer> q=new LinkedList<>();
        q.offer(0);//starting index
        
        while(!q.isEmpty())
        {
            n++;
            int size=q.size();
            for(int j=0;j<size;j++)
            {
                int i=q.poll();
                
                //move i-1
                 if(i-1>-1 && map.containsKey(arr[i-1]))
                {
                    q.offer(i-1);
                }
                
                //move i+1
                if(i+1<arr.length && map.containsKey(arr[i+1]))
                {
                    if(i+1==arr.length-1)//already it has reached the end
                        return n;
                    else
                        q.offer(i+1);
                }
                
                //move arr[i]==arr[j]
                if(map.containsKey(arr[i]))
                {
                    for(int k:map.get(arr[i]))//iterate throughout the list
                    {
                        if(k!=i)
                        {
                            if(k==arr.length-1)
                                return n;
                            q.offer(k);
                        }
                    }
                }
                
                map.remove(arr[i]);
            }
        }
        
        return n;
    }
}