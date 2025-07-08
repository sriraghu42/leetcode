class Solution {
    public int minPathSum(int[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;
        int[][] dp = new int[rowCount][colCount];
        dp[rowCount-1][colCount-1] = grid[rowCount-1][colCount-1];
        for(int i=colCount-2; i>=0; i--){
            dp[rowCount-1][i] = grid[rowCount-1][i]+dp[rowCount-1][i+1];
        }
        for(int i=rowCount-2; i>=0; i--){
            dp[i][colCount-1] = grid[i][colCount-1]+dp[i+1][colCount-1];
        }
        for(int i=rowCount-2; i>=0; i--){
            for(int j=colCount-2; j>=0; j--){
                dp[i][j] = grid[i][j] + Math.min(dp[i+1][j],dp[i][j+1]);
            }
        }
        return dp[0][0];
    }
}