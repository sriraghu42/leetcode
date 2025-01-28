class Solution {
    int[][] directions = new int[][] {{-1,0},{1,0},{0,1},{0,-1}};
    int ans = 0;
    public int findMaxFish(int[][] grid) {
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]!=0){
                    //System.out.println("Hi");
                    int[] count = new int[1];
                    dfs(grid,i,j,count);
                } 
            }
        }
        return ans;
    }

    public void dfs(int[][] grid, int i, int j, int[] count){
        count[0]+=grid[i][j];
        //System.out.println("count : "+count[0]+" , i:"+i+" , j:"+j);
        grid[i][j] = 0;
        for(int[] dir : directions){
            int x = i+dir[0];
            int y = j+dir[1];
            if(x>=grid.length || y>=grid[0].length || x<0 || y<0 || grid[x][y]==0){
                ans = Math.max(count[0],ans);
                continue;
            }
            dfs(grid,x,y,count);
        }
    }
}