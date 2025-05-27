class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        return helper(m,n,dp);
    }

    public int helper(int m, int n, int[][] dp){
        if(dp[m][n]!=0) return dp[m][n];
        if(n==1 || m==1){
            dp[m][n]=1;
        } 
        else{
            dp[m][n] = helper(m-1,n,dp) + helper(m,n-1,dp);
        } 
        return dp[m][n];
    }
}