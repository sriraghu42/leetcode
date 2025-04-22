class Solution {
    int[][] directions = new int[][] {{-1,0},{1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        int counter = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    System.out.println("Hi");
                    counter++;
                    dfs(grid,i,j);
                } 
            }
        }
        return counter;
    }

    public void dfs(char[][] grid, int i, int j){
        grid[i][j]='0';
        for(int[] dir : directions){
            int x = i+dir[0];
            int y = j+dir[1];
            if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y]=='0') continue;
            dfs(grid,x,y);
        }
    }
}