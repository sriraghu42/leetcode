class Solution {
    public int waysToSplitArray(int[] nums) {
        int len = nums.length;
        long[] prefixSum = new long[len];
        int ans = 0;
        prefixSum[0] = nums[0];
        for(int i=1; i<len; i++) prefixSum[i] = prefixSum[i-1]+nums[i];
        for(int i=0; i<len-1; i++){
            if(prefixSum[i]>=prefixSum[len-1]-prefixSum[i]) ans++;
        }
        return ans;
    }
}