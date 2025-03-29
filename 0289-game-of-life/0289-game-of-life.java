class Solution {
    int[][] directions =  new int[][] {{-1,0},{1,0},{0,1},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                int oneCount = findCount(board,i,j,rows,cols);
                if(board[i][j]==0 && oneCount==3) board[i][j]=-1;
                if(board[i][j]==1 && (oneCount<2 || oneCount>3)) board[i][j]=2;
            }
        }
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j]==2) board[i][j]=0;
                if(board[i][j]==-1) board[i][j]=1;
            }
        }
    }

    public int findCount(int[][] board, int m, int n, int rows, int cols){
        int oneCount = 0;
        for(int[] dir : directions){
            int x = m + dir[0];
            int y = n + dir[1];
            if(x<0 || x>=rows || y>=cols || y<0) continue;
            else if(board[x][y]==1 || board[x][y]==2) oneCount++;
        }
        return oneCount;
    }
}