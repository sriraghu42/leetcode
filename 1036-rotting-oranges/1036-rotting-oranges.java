class Solution {
    int[][] directions = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int rotCount = 0;
        int freshCount = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 1) freshCount++;
                else if(grid[i][j] == 2){
                    rotCount++;
                    q.add(new int[] {i,j});
                } 
            }
        }
        if(freshCount==0) return 0;
        int[] count = new int[] {freshCount};
        int[] ans = new int[1];
        bfs(grid,q,count,ans,rows,cols);
        if(count[0]>0) return -1;
        return ans[0];
    }

    public void bfs(int[][] grid, Queue<int[]> q, int[] count, int[] ans, int rows, int cols){
        while(!q.isEmpty() && count[0]>0){
            int size = q.size();
            ans[0]++;
            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                for(int[] dir: directions){
                    int x = curr[0]+dir[0];
                    int y = curr[1]+dir[1];
                    if(x<0 || x>=rows || y<0 || y>=cols || grid[x][y]!=1) continue;
                    grid[x][y]=2;
                    count[0]--;
                    q.add(new int[] {x,y});
                }
            }
        }
    }
}