class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int len = nums.length;
        int maxDiff = Math.abs(nums[0]-nums[len-1]);
        for(int i=1; i<len; i++){
            maxDiff = Math.max(maxDiff,Math.abs(nums[i]-nums[i-1]));
        }
        return maxDiff;
    }
}