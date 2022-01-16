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
    public ListNode deleteMiddle(ListNode head) {
           if(head.next == null){
            
            return null;
        }
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        ListNode prev = null;
        while(fastPtr!= null && fastPtr.next != null){
            prev = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            
        }
        
        prev.next = prev.next.next;
        return head;
        
    }
}