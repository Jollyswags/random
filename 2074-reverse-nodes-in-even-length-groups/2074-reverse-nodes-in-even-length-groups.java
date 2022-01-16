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
    public ListNode reverseEvenLengthGroups(ListNode head) {
           int i = 1;
    Stack<Integer>arr = new Stack<>();
    ListNode temp = head;
    
    while(temp != null){
        ListNode start = temp;
        int count = 0;
        while(count < i && temp != null){
            arr.add(temp.val);
            temp = temp.next;
            count++;
        }
        
        if(count%2 == 0){
            while(start != temp){
                start.val = arr.pop();
                start = start.next;
            }
        }
        i++;
    }
    return head;
    }
}