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
    Map<TreeNode,TreeNode> map = new HashMap<>();
    TreeNode startNode = null;
    public int amountOfTime(TreeNode root, int start) {
        mapParent(root,null,start);
        int time = -1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(startNode);
        Set<TreeNode> visited = new HashSet<>();
        while(!q.isEmpty()){
            int len = q.size();
            time++;
            for(int i=0; i<len; i++){
                TreeNode curr = q.poll();
                visited.add(curr);
                if(curr.left!=null && !visited.contains(curr.left)) q.add(curr.left);
                if(curr.right!=null && !visited.contains(curr.right)) q.add(curr.right);
                if(map.get(curr)!=null && !visited.contains(map.get(curr))) q.add(map.get(curr));
            }
        }
        return time;
    }

    private void mapParent(TreeNode node, TreeNode parent, int start){
        if(node==null) return;
        if(start == node.val) startNode = node;
        map.put(node,parent);
        mapParent(node.left,node,start);
        mapParent(node.right,node,start);
    }
}