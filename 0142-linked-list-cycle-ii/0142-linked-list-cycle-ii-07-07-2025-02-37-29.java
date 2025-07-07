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
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;;
        ListNode slow = head;
        ListNode fast = head;
        ListNode meet = null;
        while(slow!=null && fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                meet = slow;
                break;
            }
        }
        if(meet==null) return null;
        while(head!=meet){
            head = head.next;
            meet = meet.next;
        }
        return head;
    }
}