class Solution {
    public String[] findRelativeRanks(int[] score) {
        
        // max heap
        PriorityQueue<Pair> heap = new PriorityQueue<>((a,b)->b.score-a.score);
        
        for (int i=0; i<score.length; i++) {
            heap.add(new Pair(score[i], i));
        }
        
        String[] result = new String[score.length];
        
        while (heap.size()!=0) {
            Pair curPerson = heap.poll();
            result[curPerson.index] = getRankString(score.length-heap.size());
        }
        return result;
    }
    
    public String getRankString(int rank) {
        if (rank == 1) return "Gold Medal";
        if (rank == 2) return "Silver Medal";
        if (rank == 3) return "Bronze Medal";
        return Integer.toString(rank);
    }
}

class Pair {
    int score;
    int index;
    
    public Pair(int s, int i) {
        this.score = s;
        this.index = i;
    }
}