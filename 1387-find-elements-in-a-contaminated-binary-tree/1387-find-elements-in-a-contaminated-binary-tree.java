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
class FindElements {
    Set<Integer> set = new HashSet<>();
    public FindElements(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        root.val = 0;
        queue.offer(root);
        set.add(root.val);
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i=0; i<len; i++){
                TreeNode curr = queue.poll();
                if(curr.left!=null){
                    curr.left.val = 2*(curr.val)+1;
                    queue.offer(curr.left);
                    set.add(curr.left.val);
                }
                if(curr.right!=null){
                    curr.right.val = 2*(curr.val)+2;
                    queue.offer(curr.right);
                    set.add(curr.right.val);
                }
            }
        }
        return;
    }
    
    public boolean find(int target) {
        if(!set.contains(target)) return false;
        return true;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */