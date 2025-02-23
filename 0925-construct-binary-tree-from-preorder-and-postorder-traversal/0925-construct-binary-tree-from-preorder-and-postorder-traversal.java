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
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = postorder.length;
        for(int i=0; i<n; i++){
            map.put(postorder[i],i);
        }
        return helperRec(0,n-1,0,n-1,preorder,postorder);
    }

    public TreeNode helperRec(int preStart,int preEnd,int postStart,int postEnd,int[] preorder,int[] postorder){
        if(preStart > preEnd || postStart>postEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        if(preStart == preEnd) return root;
        int r = map.get(preorder[preStart+1]);
        int size = r - postStart + 1;
        root.left = helperRec(preStart+1,preStart+size,postStart,r,preorder,postorder);
        root.right = helperRec(preStart+size+1,preEnd,r+1,postEnd-1,preorder,postorder);
        return root; 
    }
}