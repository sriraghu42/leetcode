class Solution {
    int[][] directions = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int counter = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]=='1'){
                    helperRec(grid,i,j);
                    counter++;
                } 
            }
        }
        return counter;
    }

    public void helperRec(char[][] grid, int i , int j){
        grid[i][j] = '0';
        for(int[] dir:directions){
            int m = i + dir[0];
            int n = j + dir[1];
            if(m<0 || n<0 || m>=grid.length || n>=grid[0].length || grid[m][n]=='0') continue;
            helperRec(grid,m,n);
        }
    }
}