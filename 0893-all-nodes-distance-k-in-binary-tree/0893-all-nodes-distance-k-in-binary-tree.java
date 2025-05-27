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
    Map<TreeNode,TreeNode> map;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        map = new HashMap<>();
        dfs(root,null);
        Set<TreeNode> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        depthSearch(target,k,list,set);
        return list;
    }

    private void depthSearch(TreeNode root, int k, List<Integer> list, Set<TreeNode> set){
        if(root==null || set.contains(root)) return;
        set.add(root);
        if(k==0){
            list.add(root.val);
            return;
        } 
        depthSearch(root.left,k-1,list,set);
        depthSearch(root.right,k-1,list,set);
        depthSearch(map.get(root),k-1,list,set);
    }

    private void dfs(TreeNode root, TreeNode parent){
        if(root == null) return;
        map.put(root,parent);
        dfs(root.left,root);
        dfs(root.right,root);
    }
}