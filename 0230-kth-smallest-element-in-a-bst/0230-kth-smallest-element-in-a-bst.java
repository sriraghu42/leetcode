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
        int[] count = new int[1];
        int[] ans = new int[1];
        helperRec(root,count,k,ans);
        return ans[0];
    }

    public void helperRec(TreeNode root,int[] count,int k,int[] ans){
        if(root == null) return;
        helperRec(root.left,count,k,ans);
        count[0]++;
        if(count[0]==k){
            ans[0]=root.val;
            return;
        } 
        helperRec(root.right,count,k,ans);
        return ;
    }
}