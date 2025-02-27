class Solution {
    public int maxSubArray(int[] nums) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            prefixSum[i] = prefixSum[i-1]+nums[i];
        }
        int min = 0;
        int ans = Integer.MIN_VALUE;
        for(int num : prefixSum){
            ans = Math.max(ans, num-min);
            min = Math.min(num,min);
        }
        return ans;
    }
}