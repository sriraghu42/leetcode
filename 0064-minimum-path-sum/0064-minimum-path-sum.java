class Solution {
    public int minPathSum(int[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;
        int[][] dp = new int[rowCount][colCount];
        dp[0][0] = grid[0][0];
        for(int i=1; i<colCount; i++) dp[0][i] = grid[0][i]+dp[0][i-1];
        for(int i=1; i<rowCount; i++) dp[i][0] = grid[i][0]+dp[i-1][0];
        for(int i=1; i<rowCount; i++){
            for(int j=1; j<colCount; j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[rowCount-1][colCount-1];
    }
}