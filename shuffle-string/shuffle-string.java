class Solution {
    public String restoreString(String s, int[] indices) {
        StringBuilder sb=new StringBuilder();
        sb.append(s);
        int i;
        for(i=0;i<indices.length;i++)
        {
             sb.deleteCharAt(indices[i]);
            sb.insert(indices[i],s.charAt(i));
        }
        return sb.toString();
        
    }
}