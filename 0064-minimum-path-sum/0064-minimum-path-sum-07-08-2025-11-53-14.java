class Solution {
    int[][] directions = new int[][]{{1,0},{0,1}};
    public int minPathSum(int[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;
        int[][] dp = new int[rowCount][colCount];
        for(int[] arr : dp) Arrays.fill(arr,-1);
        return helperRec(grid,rowCount,colCount,0,0,dp);
    }

    public int helperRec(int[][] grid, int rowCount, int colCount, int i, int j, int[][] dp){
        if(i==rowCount-1 && j==colCount-1){
            return grid[i][j];
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int[] dir: directions){
            int x = dir[0]+i;
            int y = dir[1]+j;
            if(x>=rowCount || y>=colCount) continue;
            int sum = grid[i][j] + helperRec(grid,rowCount,colCount,x,y,dp);
            min = Math.min(sum,min);
        }
        dp[i][j] = min;
        return dp[i][j];
    }
}