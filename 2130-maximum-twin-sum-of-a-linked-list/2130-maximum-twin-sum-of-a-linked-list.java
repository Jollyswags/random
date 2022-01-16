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
    public int pairSum(ListNode head) {
        ListNode temp=head;
        Stack<Integer> st=new Stack();
        while(temp!=null)
        {
            st.push(temp.val);
            temp=temp.next;
        }
        temp=head;       
        int size=st.size();
        int max=Integer.MIN_VALUE;
        while(st.size()>=size/2)
        {
            int last=st.pop();
            int first=temp.val;
            max=Math.max(max,(last+first));
            temp=temp.next;
        }
        return max;
    }
}