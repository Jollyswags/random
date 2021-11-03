class Solution {
    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> map=new HashMap<>();
        char arr[]=s.toCharArray();
        int i;
        for(i=0;i<arr.length;i++)
        {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        int c=map.get(arr[0]);
        int f=1;
        for(int j:map.values())
        {
            if(c!=j)
            {
                f=0;
                break;
            }
        }
        return f==1;
        
    }
}