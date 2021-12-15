class Solution {
    public ListNode insertionSortList(ListNode head) {
	
	if (head == null || head.next == null) return head; 
	
	
	ListNode sorted = new ListNode(0); 

	ListNode unsorted = head, inserted; 
	while (unsorted != null) {
		inserted = unsorted; 

		unsorted = unsorted.next; 
		
		insert(sorted, inserted);
	}

	return sorted.next; 
}


private void insert(ListNode sorted, ListNode inserted) {
	ListNode curr = sorted.next, prev = sorted;
	while (prev != null) {
		if (curr == null || curr.val >= inserted.val) {
			prev.next = inserted;
			inserted.next = curr;
			break;
		}
		prev = curr; 
		curr = curr.next; 
	}
}
}