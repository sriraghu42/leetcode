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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        ListNode root = head;
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){
            if(curr == root && set.contains(root.val)){
                root = root.next;
                curr = curr.next;
            }
            else if(set.contains(curr.val)){
                prev.next = curr.next;
                curr = curr.next;
            }
            else{
                prev = curr;
                curr = curr.next;
            }
        }
        return root;
    }
}