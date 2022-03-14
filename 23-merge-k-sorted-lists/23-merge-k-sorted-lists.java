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
    public ListNode mergeKLists(ListNode[] lists) {
         
        int n = lists.length;
        ListNode pseudo = new ListNode();
        ListNode curr = pseudo;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> {
            if (a == null) {
                return 1;
            }
            if (b == null) {
                return -1;
            }
            return a.val - b.val;
        });
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }
        while (!minHeap.isEmpty()) {
            ListNode front = minHeap.remove();
            if (front.next != null) {
                minHeap.add(front.next);
            }
            curr.next = front;
            front.next = null;
            curr = front;
        }
        return pseudo.next;
    }
}