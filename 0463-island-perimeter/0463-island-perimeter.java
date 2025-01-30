class Solution {
    int[][] directions = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int perimeter=0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]==1){
                    for(int[] dir:directions){
                        int x = i+dir[0];
                        int y = j+dir[1];
                        if(x<0 || x>=rows || y<0 || y>=cols || grid[x][y]==0) perimeter++;
                    }
                }
            }
        }
        return perimeter;
    }
}