class Solution {
    int count = 0;
    int[][] directions = new int[][] {{-1,0},{1,0},{0,1},{0,-1}};
    public int islandPerimeter(int[][] grid) {
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    dfs(grid,i,j);
                    break;
                }
            }
        }
        return count;
    }

    public void dfs(int[][] grid, int i, int j){
        grid[i][j] = 2;
        for(int[] dir : directions){
            int x = dir[0] + i;
            int y = dir[1] + j;
            if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y]==0) count++;
            else if(grid[x][y]==1) dfs(grid,x,y);
            else continue;
        }
    }
}