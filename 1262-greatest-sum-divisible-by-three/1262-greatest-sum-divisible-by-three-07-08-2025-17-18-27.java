class Solution {
    public int maxSumDivThree(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][3];
        for(int[] arr : dp) Arrays.fill(arr,-1);
        return helperRec(nums,len,0,0,dp);
    }

    public int helperRec(int[] nums, int len, int pos, int rem, int[][] dp){
        if(pos==len){
            if(rem==0) return 0;
            else return Integer.MIN_VALUE;
        }
        if(dp[pos][rem]!=-1) return dp[pos][rem];
        int not = helperRec(nums,len,pos+1,rem,dp);
        int newRem = ((nums[pos]%3)+rem)%3;
        int take = nums[pos]+helperRec(nums,len,pos+1,newRem,dp);
        int max = Math.max(not,take);
        dp[pos][rem] = max;
        return dp[pos][rem];
    }
}