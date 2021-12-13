class Solution {
    public boolean backspaceCompare(String s, String t) {
           int i;
        String ns="",nt="";
        for(i=0;i<s.length();i++)
        {
           
            if(s.charAt(i)=='#')
                if(ns.length()==0)
                    continue;
            else
                ns=ns.substring(0,ns.length()-1);
            else
                ns+=s.charAt(i);
            
            
        }
         for(i=0;i<t.length();i++)
        {
            
             
            if(t.charAt(i)=='#')
                if(nt.length()==0)
                    continue;
            else
                nt=nt.substring(0,nt.length()-1);
            else
                nt+=t.charAt(i);
        }
        return ns.equals(nt);
    }
}