class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        int right = 0;
        while(right<nums.length){
            sum+=nums[right];
            while(left<nums.length && sum>=target){
                sum-=nums[left];
                minLen = Math.min(minLen,right-left+1);
                left++;
            }
            right++;
        }
        return minLen==Integer.MAX_VALUE?0:minLen;
    }
}