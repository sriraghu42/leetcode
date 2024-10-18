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
    public boolean isValidBST(TreeNode root) {
        if(root.left==null && root.right==null) return true;
        List<Integer> list = new ArrayList<>();
        helperRec(root,list);
        for(int i=1; i<list.size(); i++){
            if(list.get(i)<=list.get(i-1)) return false;
        }
        return true;
    }

    public TreeNode helperRec(TreeNode root, List<Integer> list){
        if(root == null) return root;
        helperRec(root.left,list);
        list.add(root.val);
        helperRec(root.right,list);
        return root;
    }
}