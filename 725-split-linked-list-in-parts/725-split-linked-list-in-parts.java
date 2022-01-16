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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode temp=head;
        ListNode cur=head;
        int n=0;
        while(temp!=null)
        {
            n++;
            temp=temp.next;
        }
        int w=n/k;
        int r=n%k;
        int i,j;
        ListNode res[]=new ListNode[k];
        for(i=0;i<k;i++)
        {
            head=cur;
            for(j=0;j<w+(i<r?1:0)-1;j++)
            {
                if(cur!=null)
                {
                    cur=cur.next;
                }
            }
            if(cur!=null)
            {
                ListNode prev=cur;
                cur=cur.next;
                prev.next=null;
            }
            res[i]=head;
        }
        return res;
    }
}