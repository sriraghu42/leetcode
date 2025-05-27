class Solution {
    public int minPathSum(int[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;
        int[] dp = new int[colCount];
        for(int row=0;row<rowCount;row++){
            for(int col=0;col<colCount;col++){
                if(row==0 && col==0) dp[col] = grid[row][col];
                else if(row==0) dp[col]+=dp[col-1]+grid[row][col];
                else if(col==0) dp[col]+=grid[row][col];
                else dp[col] = grid[row][col]+Math.min(dp[col-1],dp[col]);
            }
        }
        return dp[colCount-1];
    }

}