class Solution {
    class CharCount {
        char c;
        int count;
        CharCount(int count, char c) {
            this.count = count;
            this.c = c;
        }
    }
    
    public String longestDiverseString(int ax, int bx, int cx) {
        PriorityQueue<CharCount> pq =
            new PriorityQueue<>((a,b)->(b.count-a.count) );
        if (ax != 0) pq.add(new  CharCount(ax, 'a'));
        if (bx != 0) pq.add(new  CharCount(bx, 'b'));
        if (cx != 0) pq.add(new  CharCount(cx, 'c'));
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (!pq.isEmpty()) {
            CharCount cc = pq.poll();
            //if not happy, add next max char
            if (i >= 2 && cc.c == sb.charAt(i-1) && cc.c == sb.charAt(i-2)) {
                if (pq.isEmpty()) break;
                //remove and re-add for correct ordering
                CharCount c2 = pq.poll();
                c2.count--;
                if (c2.count > 0) pq.add(c2);
                
                sb.append(c2.c);
                i++;
            }
            sb.append(cc.c);
            cc.count--;
            if (cc.count > 0) pq.add(cc);
            i++;
        }
        
        return sb.toString();
    }
}