/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
   
 public Node flatten(Node head) {
        if(head == null) return head;
        Node dummy = new Node(-1, null, head, null);
        dfs(dummy, head);
        dummy.next.prev = null;
        return dummy.next;
    }
    public Node dfs(Node prev, Node curr) {
        if(curr == null) return prev;
        curr.prev = prev;
        prev.next = curr;
        Node temp = curr.next;
        Node child = dfs(curr, curr.child);
        curr.child = null;
        return dfs(child, temp);
    }
}