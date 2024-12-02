class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int count = 0;
        int leastabs = Integer.MAX_VALUE;
        long totAbsSum = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                int num = matrix[i][j];
                if(num <= 0){
                    count++;
                }
                leastabs = Math.min(leastabs,Math.abs(num));
                totAbsSum+= (long) Math.abs(num);
            }
        }
        if(count%2==0) return totAbsSum;
        else return totAbsSum-2*leastabs;
    }
}