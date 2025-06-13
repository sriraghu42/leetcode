class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] leftSmall = new int[len];
        int[] rightSmall = new int[len];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<len; i++){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]) stack.pop();
            leftSmall[i] = (stack.isEmpty()?-1:stack.peek());
            stack.push(i);
        }
        stack.clear();
        for(int i=len-1; i>=0; i--){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]) stack.pop();
            rightSmall[i] = (stack.isEmpty()?len:stack.peek());
            stack.push(i);
        }
        int area = 0;
        for(int i=0; i<len; i++){
            area = Math.max(area, (rightSmall[i]-leftSmall[i]-1)*heights[i]);
        }
        return area;
    }
}