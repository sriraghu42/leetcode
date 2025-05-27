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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int overhead = 0;
        ListNode dummy = new ListNode(-1);
        helper(dummy,l1,l2,overhead);
        return dummy.next;
    }

    private void helper(ListNode curr, ListNode l1, ListNode l2, int overhead){
        if(l1==null && l2==null){
            if(overhead!=0) curr.next = new ListNode(overhead);
            return;
        }
        int num = (l1==null?0:l1.val)+(l2==null?0:l2.val)+overhead;
        ListNode nex = new ListNode(num%10);
        overhead = num/10;
        curr.next = nex;
        helper(nex,l1==null?null:l1.next,l2==null?null:l2.next,overhead);
    }
}