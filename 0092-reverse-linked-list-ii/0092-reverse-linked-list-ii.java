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
        ListNode ref = new ListNode(0);
        ref.next = head;
        ListNode curr = head;
        ListNode prev = ref;
        int counter = 1;
        ListNode revStart = null;
        ListNode start = null;
        ListNode nex = null;
        while(curr!=null){
            if(counter==left){
                start = prev;
                revStart = curr;
                prev = null;
                while(counter<=right){
                    nex = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = nex;
                    counter++;
                }
                start.next = prev;
                revStart.next = nex;
                break;
            }
            else{
                prev = curr;
                curr = curr.next;
            }
            counter++;
        }
        return ref.next;
    }
}