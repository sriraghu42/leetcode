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
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root.left==null && root.right==null) return 0;
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode node){
        if(node==null) return 0;
        int leftHighest = dfs(node.left);
        int rightHighest = dfs(node.right);
        ans = Math.max(ans,leftHighest+rightHighest);
        return 1+Math.max(leftHighest,rightHighest);
    }
}