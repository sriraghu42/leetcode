class Solution {
    
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for(int num : nums) sum+=num;
        if(sum%2!=0) return false;
        int target = sum/2;
        Boolean[][] dp = new Boolean[len+1][target+1];
        return helperRec(nums,len,0,target,dp);
    }

    public boolean helperRec(int[] nums, int len, int pos, int target, Boolean[][] dp){
        if(target==0) return true;
        if(pos==len) return false;
        if(target<0) return false;
        if(dp[pos][target]!=null) return dp[pos][target];
        return dp[pos][target] = helperRec(nums,len,pos+1,target,dp) || helperRec(nums,len,pos+1,target-nums[pos],dp);
    }
}