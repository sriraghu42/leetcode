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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int[] nodes = new int[size];
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                nodes[i] = node.val;
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right); 
            }
            ans+=getMinSwaps(nodes);
        }
        return ans;
    }

// Calculate minimum swaps needed to sort an array
    private int getMinSwaps(int[] original) {
        int swaps = 0;
        int[] target = original.clone();
        Arrays.sort(target);
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < original.length; i++) {
            pos.put(original[i], i);
        }
        for (int i = 0; i < original.length; i++) {
            if (original[i] != target[i]) {
                swaps++;
                int curPos = pos.get(target[i]);
                pos.put(original[i], curPos);
                original[curPos] = original[i];
            }
        }
        return swaps;
    }
}