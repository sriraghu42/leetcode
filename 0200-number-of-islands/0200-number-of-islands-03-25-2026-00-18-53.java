class Solution {
    public int numIslands(char[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int ans = 0;
        for(int row=0; row<rowLength; row++){
            for(int col=0; col<colLength; col++){
                if(grid[row][col]=='1'){
                    ans+=1;
                    dfs(grid,rowLength,colLength,row,col);
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] grid, int rowLength, int colLength, int row, int col){
        if(row<0 || row>=rowLength || col<0 || col>=colLength || grid[row][col]=='0') return;
        grid[row][col]='0';
        dfs(grid,rowLength,colLength,row+1,col);
        dfs(grid,rowLength,colLength,row-1,col);
        dfs(grid,rowLength,colLength,row,col+1);
        dfs(grid,rowLength,colLength,row,col-1);
    }
}