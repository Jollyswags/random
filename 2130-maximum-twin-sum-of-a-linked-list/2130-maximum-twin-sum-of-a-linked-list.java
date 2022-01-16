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
                Stack<Integer> st=new Stack();
        ListNode temp=head;
        while(temp!=null){
            st.push(temp.val);
            temp=temp.next;
        }
        temp=head;
        int max=Integer.MIN_VALUE;
        int size=st.size();
        while(st.size()>size/2){
            int last=st.pop();
            int first=temp.val;
            max=Math.max(max,(first+last));
            temp=temp.next;
        }
        return max;
    }

    
}