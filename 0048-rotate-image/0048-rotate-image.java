class Solution {
    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        for(int i=0; i<rows-1; i++){
            for(int j=i+1; j<rows; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0; i<rows; i++){
            int[] row = matrix[i];
            int m = 0;
            int n = row.length-1;
            while(m<n){
                int temp = matrix[i][m];
                matrix[i][m] = matrix[i][n];
                matrix[i][n] = temp;
                m++;
                n--;
            }
        }
    }
}