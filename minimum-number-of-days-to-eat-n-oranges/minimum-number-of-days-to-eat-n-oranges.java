class Solution {
    private HashMap<Integer,Integer> mp = new HashMap<>();
    public int minDays(int n) {
        if(n <= 2)
            return n;
        if(mp.containsKey(n))
            return mp.get(n);
        
        mp.put(n, 1 + Math.min(n % 2 + minDays(n/2), n % 3 + minDays(n/3)));
        return mp.get(n);
    }
}