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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        int[] index = new int[1];
        return constructTree(preorder,map,0,preorder.length-1,index);
    }

    public TreeNode constructTree(int[] preorder, Map<Integer,Integer> map, int left, int right, int[] index){
        if(left>right) return null;
        TreeNode node = new TreeNode(preorder[index[0]]);
        int pos = map.get(node.val);
        index[0]++;
        node.left = constructTree(preorder,map,left,pos-1,index);
        node.right = constructTree(preorder,map,pos+1,right,index);
        return node;
    }
}
