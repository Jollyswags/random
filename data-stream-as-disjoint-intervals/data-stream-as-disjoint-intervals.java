class SummaryRanges {
    
    ArrayList<ArrayList<Integer>> intervals = new ArrayList<>();
    HashSet<Integer> hs = new HashSet<>();

    /** Initialize your data structure here. */
    public SummaryRanges() {
        intervals = new ArrayList<>();
    }
    
    public void addNum(int val) {
        if(intervals.size() == 0){
            ArrayList<Integer> al = new ArrayList<>();
            al.add(val);
            al.add(val);
            intervals.add(al);
            hs.add(val);
            return;
        } else {
            if(hs.contains(val)) return;
            if(hs.contains(val-1) && hs.contains(val+1)) {
                for (int i = 0;i<intervals.size()-1;i++) {
                    if(intervals.get(i).get(1) == val-1 && intervals.get(i+1).get(0) == val+1) {
                        intervals.get(i).set(1,intervals.get(i+1).get(1));
                        hs.add(val);
                        intervals.remove(i+1);
                        return;
                    }
                }
            }
            if(hs.contains(val-1)) {
                for(int i = 0; i<intervals.size();i++) {
                    if(intervals.get(i).get(1) == val-1) {
                        intervals.get(i).set(1,val);
                        hs.add(val);
                        return;
                    } 
                }
            }
            if(hs.contains(val+1)) {
                for(int i = 0; i<intervals.size();i++) {
                    if(intervals.get(i).get(0) == val+1) {
                        intervals.get(i).set(0, val);
                        hs.add(val);
                        return;
                    }
                }
            }
            ArrayList<Integer> al = new ArrayList<>();
            al.add(val);
            al.add(val);
            if(val<intervals.get(0).get(0)) {
                intervals.add(0,al);
                hs.add(val);
                return;
            }
            if(val>intervals.get(intervals.size()-1).get(1)) {
                intervals.add(al);
                hs.add(val);
                return;
            }
            for(int i = 0;i<intervals.size()-1;i++){
                if(intervals.get(i).get(1)< val && val < intervals.get(i+1).get(0)) {
                    intervals.add(i+1,al);
                    hs.add(val);
                    return;
                }
            }
        }
        return;
    }
    
    public int[][] getIntervals() {
        int[][] ans = new int[intervals.size()][2];
        for(int i = 0;i<intervals.size(); i++) {
            ans[i][0] = intervals.get(i).get(0);
            ans[i][1] = intervals.get(i).get(1);
        }
        return ans;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */