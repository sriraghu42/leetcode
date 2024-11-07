class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int counter = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]==2){
                    q.offer(new int[] {i-1,j});
                    q.offer(new int[] {i+1,j});
                    q.offer(new int[] {i,j-1});
                    q.offer(new int[] {i,j+1});
                }
            }
        }
        boolean first = true;
        while(!q.isEmpty()){
            int size = q.size();
            if(!first) counter++;
            for(int m=0; m<size; m++){
                int[] cell = q.poll();
                int a = cell[0];
                int b = cell[1];
                if(a<0 || a>=rows || b<0 || b>=cols) continue;
                if(grid[a][b] == 0 || grid[a][b]==2) continue;
                grid[a][b] = 2;
                q.add(new int[] {a-1,b});
                q.add(new int[] {a+1,b});
                q.add(new int[] {a,b-1});
                q.add(new int[] {a,b+1});
                first = false;
            }
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]==1) return -1;
            }
        }
        return counter;    
    }
}