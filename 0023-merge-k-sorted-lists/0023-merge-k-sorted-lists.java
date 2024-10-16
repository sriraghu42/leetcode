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
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode ln : lists){
            if(ln!=null) pq.offer(ln);
        }
        ListNode root = new ListNode(0);
        ListNode curr = root;
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            if(min.next!=null) pq.offer(min.next);
            curr.next = min;
            curr = curr.next;
        }
        return root.next;
    }
}