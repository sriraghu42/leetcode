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
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean reverse = false;
        while(!q.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                list.add(curr.val);
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
            if(reverse){
                    int m = 0;
                    int n = list.size()-1;
                    while(m<n){
                        int temp = list.get(m);
                        list.set(m,list.get(n));
                        list.set(n,temp);
                        m++;
                        n--;
                    } 
                }
            reverse = !reverse;
            ans.add(list);
        }
        return ans;
    }
}