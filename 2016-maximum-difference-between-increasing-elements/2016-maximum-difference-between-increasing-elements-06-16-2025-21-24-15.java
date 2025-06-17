class Solution {
    public int maximumDifference(int[] nums) {
        int ans = -1;
        int max = nums[nums.length-1];
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i]<max) ans=Math.max(ans,max-nums[i]);
            else max = nums[i];
        }
        return ans;
    }
}