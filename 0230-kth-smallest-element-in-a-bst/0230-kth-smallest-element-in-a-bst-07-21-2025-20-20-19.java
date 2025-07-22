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
    int ans = -1;
    int counter = 0;
    public int kthSmallest(TreeNode root, int k) {
        helperRec(root,k);
        return ans;
    }

    public void helperRec(TreeNode root, int k){
        if(root == null) return;
        if(ans==-1) helperRec(root.left,k);
        counter++;
        if(counter==k){
            ans = root.val;
            return;
        }
        if(ans==-1) helperRec(root.right,k);
    }
}