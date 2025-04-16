class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] leftArr = new int[len];
        int[] rightArr = new int[len];
        Arrays.fill(rightArr,len);
        Arrays.fill(leftArr,-1);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1; i<len; i++){
            while(!stack.isEmpty() && heights[stack.peek()]>heights[i]){
                rightArr[stack.pop()] = i;
            }
            stack.push(i);
        }
        stack.clear();
        stack.push(0);
        for(int i = 1; i<len; i++){
            while(!stack.isEmpty() && heights[stack.peek()]>heights[i]){
                stack.pop();
            }
            if(!stack.isEmpty()) leftArr[i] = stack.peek();
            stack.push(i);
        }
        int max = 0;
        for(int i=0; i<len; i++){
            max = Math.max(max,(rightArr[i]-leftArr[i]-1) * heights[i]);
        }
        return max;
    }
}