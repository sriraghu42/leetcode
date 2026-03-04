class Solution {
    public int numSpecial(int[][] mat) {
        int rowLen = mat.length;
        int colLen = mat[0].length;
        int count = 0;
        for(int row = 0; row < rowLen; row++){
            for(int col = 0; col < colLen; col++){
                if(mat[row][col]==1){
                    boolean isSpecial = true;
                    for(int tempRow = 0; tempRow<rowLen; tempRow++){
                        if(tempRow==row) continue;
                        if(mat[tempRow][col]!=0){
                            isSpecial = false;
                            break;
                        }
                    }
                    if(isSpecial){
                        for(int tempCol=0; tempCol<colLen; tempCol++){
                            if(tempCol==col) continue;
                            if(mat[row][tempCol]!=0){
                                isSpecial = false;
                                break;
                            }
                        }
                    }
                    if(isSpecial){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}