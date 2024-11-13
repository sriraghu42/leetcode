class Solution {
    int ans = 0;
    int[][] directions = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};

    public int maxAreaOfIsland(int[][] grid) {
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    int[] count = new int[1];
                    dfs(grid,i,j,count);
                } 
            }
        }
        return ans;
    }

    public void dfs(int[][] grid, int i, int j, int[] count){
        count[0]++;
        grid[i][j] = 0;
        for(int[] dir : directions){
            int a = i + dir[0];
            int b = j + dir[1];
            if(a<0 || b<0 || a==grid.length || b== grid[0].length || grid[a][b]==0) continue;
            dfs(grid,a,b,count);
        }
        ans = Math.max(ans,count[0]);
    }
}