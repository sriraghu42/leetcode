class Solution {
    public int minPathSum(int[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;
        int[][] dp = new int[rowCount][colCount];
        for(int[] arr : dp) Arrays.fill(arr,-1);
        dp[0][0] = grid[0][0];
        findMin(grid,rowCount-1,colCount-1,rowCount,colCount,dp);
        return dp[rowCount-1][colCount-1];
    }

    public int findMin(int[][] grid, int row, int col, int rowCount, int colCount, int[][] dp){
        if(row<0 || col<0) return Integer.MAX_VALUE;
        if(dp[row][col]>-1) return dp[row][col];
        dp[row][col] = Math.min(findMin(grid,row,col-1,rowCount,colCount,dp),findMin(grid,row-1,col,rowCount,colCount,dp))+grid[row][col];
        return dp[row][col];
    }
}