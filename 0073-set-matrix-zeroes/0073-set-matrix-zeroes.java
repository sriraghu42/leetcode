class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = cols - 1;
        boolean[][] visited = new boolean[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(matrix[i][j]==0 && !visited[i][j]) helper(matrix,i,j,left,right,bottom,top,visited);
            }
        }
    }

    public void helper(int[][] matrix, int i, int j, int left, int right, int bottom, int top, boolean[][] visited){
        visited[i][j] = true;
        for(int m=top; m<=bottom; m++){
            if(matrix[m][j]!=0){
                matrix[m][j] = 0;
                visited[m][j] = true;
            }
        }
        for(int m=left; m<=right; m++){
            if(matrix[i][m]!=0){
                matrix[i][m] = 0;
                visited[i][m] = true;
            }
        }
    }
}