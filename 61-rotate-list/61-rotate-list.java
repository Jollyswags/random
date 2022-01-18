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
    public ListNode rotateRight(ListNode head, int k) {
               if (head==null || head.next==null || k==0  )
    return head;

  //  if k>size
  ListNode node=head;
  int size=0;
  while (node!=null){//calc size
    size++;
    node=node.next;
  }
  k=k%size;//essentially that is the number of rotations
  
  ListNode prevkNode=head;
  ListNode tail=head;
  
  for (int i=0; i<k; i++)
    tail=tail.next;
  
  while (tail.next!=null){
    prevkNode=prevkNode.next;
    tail=tail.next;
  }
  
  tail.next=head;
  head=prevkNode.next;

  prevkNode.next=null;
  return head;
    }
}