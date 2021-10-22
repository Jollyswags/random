class Solution {
    public int minTimeToType(String word) {
        char curr = 'a';
        int ans = 0;
        for(char c : word.toCharArray()){
            if(c != curr){
            int tex = Math.abs(c - curr);
            // System.out.println(tex);            
            int test = Math.min(tex, 26 - tex);
            // System.out.println(test);
            ans += test;
            curr = c;
            }
            ans++;
        }
        
        return ans;
    }
}