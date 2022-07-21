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
    public ListNode reverseBetween(ListNode head, int left, int right) {
          ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
            head = head.next;            
        }
        for (int i = 0; i < right - left; i++) {
            ListNode removeNode = head.next;
            head.next = head.next.next;
            removeNode.next = pre.next;
            pre.next = removeNode;
        }
        return hair.next;
    }
}