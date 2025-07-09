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
    int moves = 0;
    public int distributeCoins(TreeNode root) {
        helperRec(root);
        return moves;
    }
    
    public int helperRec(TreeNode root){
        if(root==null) return 0;
        int a = helperRec(root.left);
        int b = helperRec(root.right);
        int coins = a+b+root.val;
        moves+=Math.abs(coins-1);
        return coins-1;
    }
}