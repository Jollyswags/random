class Solution {
    public int strongPasswordChecker(String s) {
        int len = s.length();
        int needTypes = missingTypes(s);
        List<Integer> repeatLens = countRepeat(s);
        if(len < 6) {
            return Math.max(needTypes, 6 - len);
        }
        else if(len >= 6 && len <= 20) {
            int swapCount = 0;
            for(int l : repeatLens) swapCount += l / 3;
            return Math.max(needTypes, swapCount);
        }
        else {
            int needRemove = len - 20;
            int idx = 0;
            while(idx < repeatLens.size() && needRemove > 0) {
                int l = repeatLens.get(idx);
                if(l % 3 == 0) {
                    needRemove -= 1;
                    repeatLens.set(idx, l - 1);
                }
                idx += 1;
            }
            idx = 0;
            while(idx < repeatLens.size() && needRemove > 0) {
                int l = repeatLens.get(idx);
                if(l % 3 == 1 && needRemove > 1) {
                    needRemove -= 2;
                    repeatLens.set(idx, l - 2);
                }
                idx += 1;
            }
            idx = 0;
            while(idx < repeatLens.size() && needRemove > 0) {
                int l = repeatLens.get(idx);
                while(l >= 3 && needRemove >= 3) {
                    l -= 3;
                    needRemove -= 3;
                }
                repeatLens.set(idx, l);
                idx += 1;
            }
            int swapCount = 0;
            for(int l : repeatLens) swapCount += l / 3;
            return Math.max(needTypes, swapCount) + len - 20;
            
        }
    }
    
    private int missingTypes(String s) {
        int needUpper = 1, needLower = 1, needNum = 1;
        for(char c : s.toCharArray()) {
            if(c >= 'a' && c <= 'z') needLower = 0;
            if(c >= 'A' && c <= 'Z') needUpper = 0;
            if(c >= '0' && c <= '9') needNum = 0;
        }
        return needUpper + needLower + needNum;
    }
    
    private List<Integer> countRepeat(String s) {
        List<Integer> list = new ArrayList<>();
        int idx = 1;
        int count = 1;
        while(idx < s.length()) {
            if(s.charAt(idx) == s.charAt(idx - 1)) count += 1;
            else {
                if(count >= 3) list.add(count);
                count = 1;
            }
            idx++;
        }
        if(count >= 3) list.add(count);
        return list;
    }
    
}