/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helperRec(root,p,q);
        return ans;
    }

    public boolean helperRec(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return false;
        if(root.left==null && root.right==null){
            if(root.val==p.val || root.val==q.val) return true;
            return false;
        }
        if(ans!=null) return true;
        boolean left = helperRec(root.left,p,q);
        if(left && (root.val==p.val || root.val==q.val)){
            ans = root;
            return true;
        }
        if(ans!=null) return true;
        boolean right = helperRec(root.right,p,q);
        if((right && left) || right & (root.val==p.val || root.val==q.val)){
            ans = root;
            return true;
        }
        return right || left || root.val==p.val || root.val==q.val ;
    }

}