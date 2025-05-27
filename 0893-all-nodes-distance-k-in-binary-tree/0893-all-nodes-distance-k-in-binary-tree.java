/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> map = new HashMap<>();
        dfs(map,root);
        Set<TreeNode> set = new HashSet<>();
        set.add(target);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        while(!q.isEmpty() && k>0){
            int len = q.size();
            //System.out.println("************");
            for(int i=0; i<len; i++){
                TreeNode node = q.poll();
                //System.out.println(node.val);
                if(node.left!=null && !set.contains(node.left)){
                    q.add(node.left);
                    set.add(node.left);
                } 
                if(node.right!=null && !set.contains(node.right)){
                    q.add(node.right);
                    set.add(node.right);
                } 
                if(map.containsKey(node) && !set.contains(map.get(node))){
                    q.add(map.get(node));
                    set.add(map.get(node));
                } 
            }
            k--;
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) ans.add(q.poll().val);
        return ans;
    }

    private void dfs(Map<TreeNode,TreeNode> map, TreeNode root){
        if(root == null) return;
        if(root.left!=null){
            map.put(root.left,root);
            dfs(map,root.left);
        }
        if(root.right!=null){
            map.put(root.right,root);
            dfs(map,root.right);
        }
    }
}