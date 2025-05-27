class Solution {
    public int minPathSum(int[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;
        int[][] dp = new int[rowCount][colCount];
        /*
        int sum = 0;
        for(int col=0; col<colCount;col++){
            sum+=grid[0][col];
            dp[0][col] = sum;
        }
        sum=0;
        for(int row=0; row<rowCount; row++){
            sum+=grid[row][0];
            dp[row][0] = sum;
        }
        */
        return helper(grid,rowCount-1,colCount-1,dp);
    }

    private int helper(int[][] grid, int row, int col, int[][] dp){
        if(row==0 && col==0) return grid[row][col];
        if(row<0 || col<0) return Integer.MAX_VALUE;
        if(dp[row][col]!=0) return dp[row][col];
        dp[row][col] = grid[row][col]+Math.min(helper(grid, row, col-1, dp) , helper(grid,row-1,col,dp));
        return dp[row][col];
    }
}