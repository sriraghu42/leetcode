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
        if(head.next==null) return head;
        ListNode start = null;
        ListNode end = null;
        ListNode curr = head;
        int counter = 1;
        while(curr!=null){
            if(counter==left-1) start = curr;
            if(counter==right+1) {
                end = curr;
                break;
            }
            counter++;
            curr = curr.next;
        }
        curr = head;
        for(int i=0; i<left-1; i++){
            curr = curr.next;
        }
        ListNode prev = end;
        ListNode temp = null;
        while(curr!=end){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        if(start!=null) start.next = prev;
        return start==null?prev:head;
    }
}