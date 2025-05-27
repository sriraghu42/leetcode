class Solution {
    public int minPathSum(int[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;
        int[][] dp = new int[rowCount][colCount];
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
        for(int row=1;row<rowCount;row++){
            for(int col=1;col<colCount;col++){
                dp[row][col] = grid[row][col]+Math.min(dp[row][col-1],dp[row-1][col]);
            }
        }
        return dp[rowCount-1][colCount-1];
    }

}