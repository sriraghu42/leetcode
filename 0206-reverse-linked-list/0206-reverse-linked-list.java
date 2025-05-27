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
    public ListNode reverseList(ListNode head) {
        return helper(null,head);
    }

    private ListNode helper(ListNode prev, ListNode curr){
        if(curr==null) return prev;;
        ListNode nextNode = curr.next;
        curr.next = prev;
        return helper(curr,nextNode);
    }
}