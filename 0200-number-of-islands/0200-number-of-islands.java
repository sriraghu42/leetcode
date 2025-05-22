class Solution {
    int[][] directions = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int ans = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j,rows,cols);
                    ans++;
                } 
            }
        }
        return ans;
    }


    public void dfs(char[][] grid, int i, int j, int rows, int cols){
        grid[i][j]='0';
        for(int[] dir : directions){
            int x = i+dir[0];
            int y = j+dir[1];
            if(x<0 || x>=rows || y<0 || y>=cols || grid[x][y]=='0') continue;
            dfs(grid,x,y,rows,cols);
        }
    }
}