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
        ListNode root = new ListNode(-1);
        ListNode curr = root;
        int overhead = 0;
        while(l1!=null || l2!=null){
            int sum = overhead+(l1!=null?l1.val:0)+(l2!=null?l2.val:0);
            curr.next = new ListNode(sum%10);
            overhead = sum/10;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
            curr = curr.next;
        }
        if(overhead!=0) curr.next = new ListNode(overhead);
        return root.next;
    }
}