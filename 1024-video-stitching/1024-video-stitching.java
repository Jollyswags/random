class Solution {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, (a, b) -> a[0] - b[0]);
        
        int cur = 0;
        int low = 0;
        int count = 0;
        while (cur < clips.length && clips[cur][0] <= low && low < time) {
            int maxUp = 0;
            
            while (cur < clips.length && clips[cur][0] <= low) {
                maxUp = Math.max(maxUp, clips[cur][1]);
                cur++;
            }
            
            count++;
            low = maxUp;
        }
        
        return low >= time ? count : -1;
    }
}
//nlogn
//1