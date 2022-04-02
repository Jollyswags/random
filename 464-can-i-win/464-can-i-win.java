class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
        if(sum < desiredTotal) return false;
        if(desiredTotal <= 0) return true;
        boolean[] used = new boolean[maxChoosableInteger + 1];
        Map<Integer, Boolean> memo = new HashMap<>();
        return canIWin(0, desiredTotal, used, memo, 0);
    }
    
    private boolean canIWin(int sum, int desiredTotal, boolean[] used, Map<Integer, Boolean> memo, int bitMap) {
        if (sum >= desiredTotal) return false;
        Boolean status = memo.get(bitMap);
        if (status != null) return status;
        // If the opponent always win or I always lose, then win is false
        for (int i = 1; i < used.length; i++) {
            if (!used[i]) {
                used[i] = true;
                status = !canIWin(sum + i, desiredTotal, used, memo, bitMap | (1 << i));
                used[i] = false;
                if (status) break;
            }
        }
        memo.put(bitMap, status);
        return status;
    }
}