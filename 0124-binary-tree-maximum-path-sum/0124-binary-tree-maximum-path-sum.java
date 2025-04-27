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
    int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxValue;
    }

    public int dfs(TreeNode node){
        if(node==null) return 0;
        int leftVal = Math.max(dfs(node.left),0);
        int rightVal = Math.max(dfs(node.right),0);
        maxValue = Math.max(maxValue,node.val+leftVal+rightVal);
        return node.val+Math.max(leftVal,rightVal);
    }
}