class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        MyDSU myDSU = new MyDSU(s.length());
        HashMap<Integer,List<Character>> map = new HashMap<>();
        for(List<Integer> edge: pairs) {
            int src = edge.get(0);
            int des = edge.get(1);
            myDSU.union(src,des);
        }
        for (int i = 0; i < s.length(); i++) {
            int parent = myDSU.find(i);
            if(!map.containsKey(parent)) map.put(parent, new ArrayList<>());
            map.get(parent).add(s.charAt(i));
        }
        
        StringBuilder result = new StringBuilder();
        
        for (List<Character> characters : map.values()) {
            Collections.sort(characters, Collections.reverseOrder());
        }
        for (int i = 0; i < s.length(); i++) {
            List<Character> characters = map.get(myDSU.find(i));
            char currentMin = characters.remove(characters.size()-1);
            result.append(currentMin);
        }
        
        return result.toString();
        
    }
}

class MyDSU {
    
    int [] parent, rank;
    int component;
    public MyDSU(int size) {
        parent = new int [size];
        rank = new int [size];
        
        for(int i=0;i<size;i++) {
            parent[i]=i;
            rank[i]=0;
        }
        component = size;
    }
    
    public int find(int x) {
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    
    public boolean union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        
        if(parentX==parentY) return false;
        if(rank[parentX]>rank[parentY]) {
            parent[parentY]=parentX;
        } else if (rank[parentY]>rank[parentX]) {
            parent[parentX]=parentY;
        } else {
                parent[parentY]=parentX;
                rank[parentX]++;
        }
        component--;
        return true;
    }
    
    public int getComponent() {
        return component;
    }
    
}