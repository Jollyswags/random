/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)   
        return null;
    HashMap<Node, Node> map = new HashMap<>();
    Node currNode = head;
    
    // creating copy node and copying its data;
    while(currNode != null){
        map.put(currNode, new Node(currNode.val));
        currNode = currNode.next;
    }
    
    // copy next and random pointer
    for(Map.Entry<Node, Node> entry: map.entrySet()){
        Node node = entry.getValue();
        
        node.next = map.get(entry.getKey().next);
        node.random = map.get(entry.getKey().random);
    }
    
    return map.get(head);  
    }
}