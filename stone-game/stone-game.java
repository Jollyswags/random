class Solution {
    public boolean stoneGame(int[] piles) {
        int i,a=0,b=0;
        LinkedList<Integer> l= new LinkedList<>();
        for(i=0;i<piles.length;i++)
        {
            l.add(piles[i]);
        }
        for(i=0;i<piles.length;i++)
        {
           if(i%2==0)
           {
               int x=Collections.max(l,null);
             int y=l.indexOf(x);
                l.remove(y);
               a+=x;

           }
            else
            {
                int x=Collections.max(l,null);
               int y=l.indexOf(x);
                l.remove(y);
               b+=x;
            }
        }
        return a>b;
        
    }
}