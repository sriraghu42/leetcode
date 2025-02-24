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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = inorder.length;
        for(int i=0; i<len; i++) map.put(inorder[i],i);
        int[] index = new int[1];
        return helperRec(preorder,inorder,index,0,len-1);
    }

    public TreeNode helperRec(int[] preorder, int[] inorder, int[] index, int left, int right){
        if(index[0]>=inorder.length || left>right) return null;
        TreeNode root = new TreeNode(preorder[index[0]]);
        int pos = map.get(root.val);
        index[0]++;
        root.left = helperRec(preorder,inorder,index,left,pos-1);
        root.right = helperRec(preorder,inorder,index,pos+1,right);
        return root;
    }
}