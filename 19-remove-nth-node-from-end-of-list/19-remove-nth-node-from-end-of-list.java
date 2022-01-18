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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
            return null;
        ListNode dummy=new ListNode(0);
        ListNode temp=head,node;
        int c=0;
        while(temp!=null)
        {
            c++;
            temp=temp.next;
        }
        int i;
        dummy.next=head;
       node=dummy;
        for(i=0;i<c-n;i++)
        {
            node=node.next;
        }
        if(n==1)
        node.next=null;
        else
            node.next=node.next.next;
        return dummy.next;       
            
    }
}