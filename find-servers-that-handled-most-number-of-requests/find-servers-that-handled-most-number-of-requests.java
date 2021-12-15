class Solution 
{
    public List<Integer> busiestServers(int k, int[] time, int[] load) 
    {
        PriorityQueue<int[]> q=new PriorityQueue<int[]>((a,b)->((int[])a)[1]-((int[])b)[1]);
        TreeSet<Integer> ptr=new TreeSet<Integer>();
        for(int i=0;i<k;++i)
            ptr.add(i);
        int[] count=new int[k];
        int val=0;
        for(int i=0;i<time.length;++i)
        {
            while(!q.isEmpty()&&q.peek()[1]<=time[i])
                ptr.add(q.poll()[0]);
            int server=i%k;
            int ret=-1;
            if(ptr.isEmpty())
                continue;
            else if(ptr.contains(server))
                ret=server;
            else
            {
                Integer temp=ptr.higher(server);
                if(temp!=null)
                    ret=temp;
                else
                    ret=ptr.first();
            }
            if(ret!=-1)
            {
                val=Math.max(val,++count[ret]);
                ptr.remove(ret);
                q.add(new int[]{ret,time[i]+load[i]});
            }
        }
        List<Integer> ret=new ArrayList<Integer>();
        for(int i=0;i<k;++i)
            if(count[i]==val)
                ret.add(i);
        return ret;
    }
}