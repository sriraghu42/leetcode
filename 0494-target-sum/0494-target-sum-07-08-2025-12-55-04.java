class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;
        int[][] dp = new int[len][2001];
        for(int[] arr : dp) Arrays.fill(arr,-1);
        return helperRec(nums,len,0,1000,target+1000,dp);
    }

    public int helperRec(int[] nums, int len, int pos, int sum, int target, int[][] dp){
        if(pos==len){
            if(sum==target) return 1;
            return 0;
        }
        if(dp[pos][sum]!=-1) return dp[pos][sum];
        int minus = helperRec(nums,len,pos+1,sum+nums[pos],target,dp);
        int plus = helperRec(nums,len,pos+1,sum-nums[pos],target,dp);
        return dp[pos][sum] = minus + plus;
    }
}