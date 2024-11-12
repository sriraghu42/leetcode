class Solution {
    int ans = 0;
    int[][] directions = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
    public int getMaximumGold(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]!=0) helperRec(grid,i,j,visited,0);
            }
        }
        return ans;
    }

    public void helperRec(int[][] grid, int i, int j, boolean[][] visited, int sum){
        sum+=grid[i][j];
        visited[i][j] = true;
        for(int[] dir : directions){
            int m = i+dir[0];
            int n = j+dir[1];
            if(m<0 || n<0 || m>=grid.length || n>=grid[0].length || visited[m][n] || grid[m][n]==0) continue;
            helperRec(grid,m,n,visited,sum);
            
        }
        visited[i][j] = false;
        ans = Math.max(sum,ans);
    }
}