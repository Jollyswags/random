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
    public ListNode mergeInBetween(ListNode l1, int a, int b, ListNode l2) {
      ListNode temp;
        ListNode head=new ListNode(0);
        temp=head;
        int i;
        for(i=0;i<=b;i++)
        {
            if(i<a)
            {
                temp.next=l1;
                l1=l1.next;
                temp=temp.next;
            }
            else
            {
                l1=l1.next;
            }
        }
        while(l2!=null)
        {
            temp.next=l2;
            l2=l2.next;
            temp=temp.next;
        }
        l2=l1;
        while(l2!=null)
        {
            temp.next=l2;
            l2=l2.next;
            temp=temp.next;
        }
        return head.next;
    }
}