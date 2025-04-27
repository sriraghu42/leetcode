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
        if(root.left==null && root.right==null) return root.val;
        dfs(root);
        return maxValue;
    }

    public int dfs(TreeNode node){
        if(node==null) return 0;
        if(node.left==null && node.right==null){
            maxValue = Math.max(maxValue,node.val);
            return Math.max(node.val,0);
        } 
        int leftVal = dfs(node.left);
        int rightVal = dfs(node.right);
        maxValue = Math.max(maxValue,node.val+leftVal+rightVal);
        return Math.max(node.val+Math.max(leftVal,rightVal),0);
    }
}