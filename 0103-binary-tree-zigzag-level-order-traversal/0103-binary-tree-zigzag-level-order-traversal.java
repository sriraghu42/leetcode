/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean zigzag = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            Deque<Integer> dq = new LinkedList<>();
            for(int i=0; i<size; i++){
                TreeNode curr = queue.poll();
                if(zigzag) dq.addFirst(curr.val);
                else dq.addLast(curr.val);
                if(curr.left!=null) queue.offer(curr.left);
                if(curr.right!=null) queue.offer(curr.right);
            }
            res.add(new ArrayList<>(dq));
            zigzag=!zigzag;
        }
        return res;
    }
}