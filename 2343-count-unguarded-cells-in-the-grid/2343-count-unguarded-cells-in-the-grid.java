class Solution {
    int[][] directions = new int[][] {{-1,0},{1,0},{0,1},{0,-1}};
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] grid = new char[m][n];
        for(int[] guard : guards){
            grid[guard[0]][guard[1]] = 'G';
        }
        for(int[] wall : walls){
            grid[wall[0]][wall[1]] = 'W';
        }
        for(int[] guard : guards){
            for(int[] dir : directions){
                int i = guard[0]+dir[0];
                int j = guard[1]+dir[1];
                while(i<m && i>=0 && j<n && j>=0 && grid[i][j]!='G' && grid[i][j]!='W'){
                    grid[i][j]='M';
                    i+= dir[0];
                    j+= dir[1];
                }
            }
        }
        int counter = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==0) counter++;
            }
        }
        return counter;
    }
}