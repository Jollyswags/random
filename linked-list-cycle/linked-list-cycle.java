/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
         ListNode slow = head;
		ListNode fast = head;
		
		// If fast or slow pointer is null, therefore, linked list has an end
		while (fast != null && slow != null) {
					
			// If fast.next is null, then we cannot move fast pointer by 2 nodes, hence end
			// If we check this in while loop's contition, then runtime error when fast == null
			if (fast.next == null)
				return false;
			
			slow = slow.next;
			fast = fast.next.next;
			
			// If there is a cycle/loop, eventually slow and fast pointers will collide
			if (slow == fast)
				return true;
		}
		return false;
        
    }
}