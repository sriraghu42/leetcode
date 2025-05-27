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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        helper(dummy,head);
        return dummy.next;
    }

    private void helper(ListNode prev, ListNode curr){
        if(curr==null || curr.next==null) return;
        ListNode nextNode = curr.next.next;
        prev.next = curr.next;
        curr.next.next = curr;
        curr.next = nextNode;
        helper(curr,nextNode);
    }
}