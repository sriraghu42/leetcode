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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null) return true;
        else if(root==null || subRoot==null) return false;
        if(isSame(root,subRoot)) return true;
        else return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }


    public boolean isSame(TreeNode root, TreeNode subRoot){
        if(root==null && subRoot==null) return true;
        else if(root==null || subRoot==null) return false;
        return (root.val==subRoot.val) && isSame(root.left,subRoot.left) && isSame(root.right,subRoot.right);
    }
}