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
    public int maxPathSum(TreeNode root) {
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        helperRec(root,ans);
        return ans[0];
    }

    public int helperRec(TreeNode root, int[] ans){
        if(root==null) return 0;
        int a = Math.max(helperRec(root.left,ans),0);
        int b = Math.max(helperRec(root.right,ans),0);
        ans[0] = Math.max(ans[0],root.val+a+b);
        return root.val+Math.max(a,b);
    }
}