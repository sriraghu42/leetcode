class Solution {
    int[][] directions = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    int perimeter = 0;
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]==1) dfs(grid,rows,cols,i,j);
            }
        }
        return perimeter;
    }

    public void dfs(int[][] grid, int rows, int cols, int i, int j){
        grid[i][j] = -1;
        for(int[] dir:directions){
            int x = i+dir[0];
            int y = j+dir[1];
            if(x<0 || x>=rows || y<0 || y>=cols || grid[x][y]==0) perimeter++;
            else if(grid[x][y] == -1) continue;
            else dfs(grid,rows,cols,x,y);
        }
    }
}