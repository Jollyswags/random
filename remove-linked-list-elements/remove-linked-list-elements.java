/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
         public ListNode removeElements(ListNode head, int val) {
         if(head==null){
        return null;
    }
    ListNode a=head;
    while(a!=null){
        if(a.next!=null && a.next.val==val){
            a.next=a.next.next;
            
        }
        else{
        a=a.next;
        }
        
    }
    if( head.next==null && head.val==val ){
        head=null;
    }
    else if(head.next!=null && head.val==val ){
        head=head.next;
    }
    return head;
    }
}