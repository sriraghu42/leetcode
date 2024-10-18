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
    public ListNode partition(ListNode head, int x) {
        ListNode a = new ListNode(0);
        ListNode start = a;
        ListNode b = new ListNode(0);
        ListNode mid = b;
        ListNode curr = head;
        while(curr!=null){
            if(curr.val<x){
                a.next = curr;
                a = a.next;
            }
            else{
                b.next = curr;
                b = b.next;
            }
            curr = curr.next;
        }
        b.next = null;
        a.next = mid.next;
        return start.next;
    }
}