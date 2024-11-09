class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int counter = 0;
        int freshOranges = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]==2) q.offer(new int[] {i,j});
                if(grid[i][j]==1) freshOranges++;
            }
        }
        if(freshOranges==0) return 0;
        int[][] directions = new int[][] {{-1,0},{0,1},{1,0},{0,-1}};
        boolean first = true;
        while(!q.isEmpty()){
            int size = q.size();
            if(!first) counter++;
            for(int m=0; m<size; m++){
                int[] cell = q.poll();
                for(int[] dir : directions){
                    int a = cell[0] + dir[0];
                    int b = cell[1] + dir[1];
                    if(a<0 || a>=rows || b<0 || b>=cols) continue;
                    if(grid[a][b] == 0 || grid[a][b]==2) continue;
                    grid[a][b] = 2;
                    q.add(new int[] {a,b});
                    freshOranges--;
                }
                first = false;
            }
        }
        return freshOranges==0?counter:-1;    
    }
}