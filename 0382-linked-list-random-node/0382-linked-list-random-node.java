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
   ListNode h;
    public Solution(ListNode head) {
        h=head;
    }
    
    public int getRandom() {
        int val=0,scope=1;
        ListNode curr=h;
        while(curr!=null)
        {
            if(Math.random()<1.0/scope)
                val=curr.val;
            scope+=1;
            curr=curr.next;
        }
        return val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */