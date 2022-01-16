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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head==null)
            return new int[] {-1,-1};
        ListNode curr=head;
        int prev=curr.val,min=Integer.MAX_VALUE,first=Integer.MAX_VALUE,last=0,i=0;
        while(curr.next!=null)
        {
            if ((prev < curr.val && curr.val > curr.next.val) || 
            (prev> curr.val && curr.val < curr.next.val))
            {
                
                if(last!=0)
                {
                     min=Math.min(min,i-last);
                }
                last=i;    
                first=Math.min(first,i);
            }                
                prev=curr.val;
                curr=curr.next;
            i++;
            
        }
        if(min==Integer.MAX_VALUE)
            return new int[]{-1,-1};
        return new int[]{min,(last-first)};
    }
}