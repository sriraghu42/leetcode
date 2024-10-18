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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        helperRec(root,list,k);
        return list.get(list.size()-1);
    }

    public void helperRec(TreeNode root, List<Integer> list,int k){
        if(root == null) return;
        if(list.size()==k) return;
        helperRec(root.left,list,k);
        if(list.size()==k) return;
        list.add(root.val);
        if(list.size()==k) return;
        helperRec(root.right,list,k);
    }
}