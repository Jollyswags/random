class Solution {
    public class TrieNode{
        TrieNode children[];
        TrieNode(){
            children = new TrieNode[2];
        }
    }
    
    TrieNode root;
    
    public void insert(int val){
        TrieNode curr = root;
        
        int bitIdx = 31;
        
        while(bitIdx-->= 0){
            int mask = (1<<bitIdx);
            int bit = (val&mask) == 0 ? 0 : 1;
            
            TrieNode node = curr.children[bit];
            if(node == null){
                node = new TrieNode();
                curr.children[bit]= node;
            }
            
            curr = node;
        }
    }
    
    public int find(int val){
        TrieNode curr = root;
        
        int bitIdx = 31;
        int res = 0;
        
        while(bitIdx-->= 0){   
            int mask = (1<<bitIdx); 
            int bit = (val&mask) == 0 ? 0 : 1;
            
            TrieNode node = curr.children[bit];
            if(bit == 0){  
				if(node == null) {          // this means only bit 1 is present 
                    node = curr.children[1];
                    res |= mask;             //  updating our bit to 1
                }
            }else{
                if(node == null){        // only bit 0 is present
                    node = curr.children[0];    // simply passing our node without updating 
										      //because zeros are already there  and need not to be updated
				}else{                         
                    res |= mask;
                }
            }
            curr = node;
        }
        return res;
    }
    
    public int findMaximumXOR(int[] nums) {
        root = new TrieNode();
        
        for(int V:nums){
            insert(V);
        }
        
        int ans = 0;
        
        for(int V:nums){
            int comp = Integer.MAX_VALUE ^ V;
            int res = find(comp);
            ans = Math.max(ans, res ^ V);
        }
        
        return ans;
    }
}