class Solution {
    int[][] directions = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int ans = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]=='1'){
                    bfs(grid,i,j,rows,cols);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void bfs(char[][] grid, int i, int j, int rows, int cols){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i,j});
        grid[i][j]='0';
        while(!q.isEmpty()){
            int[] arr = q.poll();
            i = arr[0];
            j = arr[1];
            for(int[] dir : directions){
                int x = i+dir[0];
                int y = j+dir[1];
                if(x<0 || x>=rows || y<0 || y>=cols || grid[x][y]=='0') continue;
                grid[x][y] = '0';
                q.add(new int[] {x,y});
            }
        }
    }
}