class Solution {
    int[][] directions = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]==1) return dfs(grid,rows,cols,i,j);
            }
        }
        return 0;
    }

    public int dfs(int[][] grid, int rows, int cols, int i, int j){
        grid[i][j] = -1;
        int counter = 0;
        for(int[] dir:directions){
            int x = i+dir[0];
            int y = j+dir[1];
            if(x<0 || x>=rows || y<0 || y>=cols || grid[x][y]==0) counter++;
            else if(grid[x][y] == -1) continue;
            else counter+=dfs(grid,rows,cols,x,y);
        }
        return counter;
    }
}