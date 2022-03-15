import java.util.*; 

class Solution {	
    Node root = new Node();         //Trie Root
    List<String> ans = new ArrayList<>();
    
    public List<String> removeSubfolders(String[] folder) {
        for(String fl : folder) {
            insert(fl);
        }
        
        for(Node child : root.children.values()) {
            findFirstNonNull(child);
        }
        
        return ans;
    }
    
    private void findFirstNonNull(Node node) {
        if(node.word != null) {
            ans.add(node.word);
            return;
        }
        
        for(Node child : node.children.values()) {
            findFirstNonNull(child);
        }
    }
    
    private void insert(String folder) {
        Node curr = root;        
        StringTokenizer tokeniser = new StringTokenizer(folder, "/");             //more efficient than string.split() 
		
        while(tokeniser.hasMoreTokens()) {			
			//stop insertion of folder into trie if root folder encountered
            if(curr.word != null) {
                return;
            }
						
            String str = tokeniser.nextToken();
            if(!curr.children.containsKey(str)) {
                curr.children.put(str, new Node());
            }			
            curr = curr.children.get(str);
        }
        curr.word = folder;
    }
    
}

//Trie Node declaration - storing word in the end node for easy reference
class Node{
    Map<String, Node> children = new HashMap<>();
    String word;
}