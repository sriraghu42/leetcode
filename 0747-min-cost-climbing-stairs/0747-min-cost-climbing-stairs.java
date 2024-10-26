class Solution {
    int[] arr;
    int[] cost;
    public int minCostClimbingStairs(int[] cost) {
        //Bottom-up approach
        /* 
        int[] dp = new int[cost.length+1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = Math.min(cost[0],cost[1]);
        for(int i=3; i<=cost.length; i++){
            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[cost.length];
        */

        //Top-down approach
        this.cost = cost;
        this.arr = new int[cost.length+1];
        Arrays.fill(arr,-1);
        return dp(cost.length);
    }

    public int dp(int n){
        if(n==0 || n==1) return 0;
        if(arr[n]==-1) arr[n] = Math.min(cost[n-1]+dp(n-1),cost[n-2]+dp(n-2));
        return arr[n];
    }
}