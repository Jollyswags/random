class Solution {
     HashMap<Integer, Boolean> cache;
    public boolean winnerSquareGame(int n) {
        cache = new HashMap();
        return canAliceWin(n);
    }
    
    private boolean canAliceWin(int n){
        if(n <= 0) return false;
        
        //reterive from cache 
        if(cache.containsKey(n)) return cache.get(n);
        
        //find anytime Bob will lose the game
        boolean isBobLose = false;
        
        //just iterate 1 to the square root(n)
        for(int i = 1; i* i <= n; i++){
            if(!canAliceWin(n - (i * i))){
                isBobLose = true;
                break;
            }
        }
        
        //save in the cache
        cache.put(n, isBobLose);
        
        return isBobLose;
    }
}