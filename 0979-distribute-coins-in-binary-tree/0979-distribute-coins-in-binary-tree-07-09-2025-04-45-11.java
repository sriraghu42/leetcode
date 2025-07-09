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
    public int distributeCoins(TreeNode root) {
        int nodes = countNodes(root);
        //System.out.println(nodes);
        helperRec(root,nodes);
        return ans;
    }

    public int helperRec(TreeNode root, int nodes){
        if(root==null) return 0;
        int left = helperRec(root.left,nodes);
        int right = helperRec(root.right,nodes);
        int coins = root.val + right + left;
        if(coins!=1) ans+=Math.abs(coins-1);
        return coins-1;
    }

    public int countNodes(TreeNode root){
        if(root==null) return 0;
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}