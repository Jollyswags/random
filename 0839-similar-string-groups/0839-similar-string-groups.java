class Solution {
    int par[];
    public int findpar(int x){
        return par[x]==x?x:findpar(par[x]);
    }
    public int numSimilarGroups(String[] strs) {
        int n=strs.length;
        par=new int[n];
        for(int i=0;i<n;i++){
            par[i]=i;
        }
        int size=strs[0].length();
        for(int i=0;i<n;i++){
 
           int p1=findpar(i);
            String s1=strs[i];
            for(int j=i+1;j<n;j++){
                String s2=strs[j];
                int count=0;
                for(int k=0;k<size;k++){
                    if(s1.charAt(k)==s2.charAt(k)){
                        count++;
                    }
                }
                if(count>=size-2){
                    int p2=findpar(j);
                    if(p1!=p2){
                        par[p2]=p1;
                    }
                }
            }
        }
        int sim=0;
        for(int i=0;i<n;i++){
            System.out.print(par[i]+" ");
            if(par[i]==i){
                sim++;
            }
        }
        return sim;
    }
}