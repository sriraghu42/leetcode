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
    int counter = 0;
    public int goodNodes(TreeNode root) {
        search(root,root.val);
        return counter;
    }

    public void search(TreeNode root, int min){
        if(root == null) return;
        if(root.val>=min) counter++;
        search(root.left,Math.max(min,root.val));
        search(root.right,Math.max(min,root.val));
    }
}