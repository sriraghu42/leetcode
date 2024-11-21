class Solution {

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] grid = new char[m][n];
        for(int[] guard : guards){
            grid[guard[0]][guard[1]] = 'G';
        }
        for(int[] wall : walls){
            grid[wall[0]][wall[1]] = 'W';
        }
        boolean[][] marked = new boolean[m][n];
        for(int[] guard : guards){
            int i = guard[0];
            int j = guard[1];
            for(int k=i+1;k<m;k++){
                if(grid[k][j]=='G' || grid[k][j]=='W') break;
                marked[k][j] = true;
            }
            for(int k=i-1;k>=0;k--){
                if(grid[k][j]=='G' || grid[k][j]=='W') break;
                marked[k][j] = true;
            }
            for(int k=j+1;k<n;k++){
                if(grid[i][k]=='G' || grid[i][k]=='W') break;
                marked[i][k] = true;
            }
            for(int k=j-1;k>=0;k--){
                if(grid[i][k]=='G' || grid[i][k]=='W') break;
                marked[i][k] = true;
            }
        }
        int counter = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]!='G' && grid[i][j]!='W' && !marked[i][j]) counter++;
            }
        }
        return counter;
    }
}