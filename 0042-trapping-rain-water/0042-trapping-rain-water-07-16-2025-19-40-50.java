class Solution {
    public int trap(int[] height) {
        int leftMax = 0;
        int len = height.length;
        int[] leftHeighest = new int[len];
        for(int i=0; i<len; i++){
            leftHeighest[i] = leftMax;
            leftMax = Math.max(leftMax,height[i]);
        }
        int[] rightHeighest = new int[len];
        int rightMax = 0;
        for(int i=len-1; i>=0; i--){
            rightHeighest[i] = rightMax;
            rightMax = Math.max(rightMax,height[i]);
        }
        int ans = 0;
        for(int i=0; i<len; i++){
            if(leftHeighest[i]>=height[i] && rightHeighest[i]>=height[i]){
                ans+= (Math.min(leftHeighest[i],rightHeighest[i]) - height[i]);
            }
        }
        return ans;
    }
}