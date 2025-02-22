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
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int len = traversal.length();
        int index = 0;
        while(index<len){
            int depth = 0;
            while(index<len && traversal.charAt(index)=='-'){
                index++;
                depth++;
            } 
            int value = 0;
            while(index<len && traversal.charAt(index)!='-'){
                value = value*10 + (traversal.charAt(index)-'0');
                index++;
            }
            TreeNode currNode = new TreeNode(value);
            while(stack.size()>depth) stack.pop();
            if(!stack.isEmpty()){
                TreeNode parent = stack.peek();
                if(parent.left==null) parent.left = currNode;
                else parent.right = currNode;
            }
            stack.push(currNode);
        }
        return stack.get(0);
    }
}