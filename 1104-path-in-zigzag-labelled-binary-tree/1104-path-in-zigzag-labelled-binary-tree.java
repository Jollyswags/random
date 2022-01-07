class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        int temp=label;
        int level=0;
        while(temp!=0)
        {
            temp/=2;
            level++;
        }
        List<Integer> l=new ArrayList<>();
        while(level>0)
        {
            l.add(label);
            label=3*((int)Math.pow(2,level-1))-1-label;
            label/=2;
            level--;
        }
        Collections.reverse(l);
        return l;
    }
}