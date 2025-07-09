class Solution {
    
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for(int num : nums) sum+=num;
        if(sum%2!=0) return false;
        int target = sum/2;
        int[][] dp = new int[len+1][target+1];
        for(int[] arr : dp) Arrays.fill(arr,-1);
        return helperRec(nums,len,0,target,dp);
    }

    public boolean helperRec(int[] nums, int len, int pos, int target, int[][] dp){
        if(pos==len){
            if(target==0) return true;
            return false;
        }
        if(target<0) return false;
        if(dp[pos][target]!=-1) return dp[pos][target]==1;
        boolean check = helperRec(nums,len,pos+1,target,dp) || helperRec(nums,len,pos+1,target-nums[pos],dp);
        dp[pos][target] = check?1:0;
        return check;
    }
}