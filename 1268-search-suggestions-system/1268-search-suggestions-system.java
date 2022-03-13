class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
         String str="";
        List<List<String>> res=new ArrayList<>();
        for(int i=0;i<searchWord.length();i++)
        {
            
             PriorityQueue<String> pq = new PriorityQueue<>((a,b)->(a.compareTo(b)));
           str+=searchWord.charAt(i);
            for(String p:products)
            {
                if(p.length()>=str.length())
                {
                    String temp=p.substring(0,str.length());
                if(str.equals(temp))
                    pq.add(p);
                }
                    
            }
            List<String> ans=new ArrayList<>();
            int l=0;
            if(pq.size()>3)
                l=3;
            else
                l=pq.size();
            for(int j=0;j<l;j++)
                ans.add(pq.poll());
            res.add(ans);
        }
        return res;
        
    }
}