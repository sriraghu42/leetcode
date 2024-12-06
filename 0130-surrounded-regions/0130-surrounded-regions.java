class Solution {
    int[][] directions = new int[][] {{-1,0},{1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for(int i=0; i<rows; i++){
            if(board[i][0] == 'O') dfs(board,i,0);
            if(board[i][cols-1] == 'O') dfs(board,i,cols-1);
        }
        for(int j=0; j<cols; j++){
            if(board[0][j] == 'O') dfs(board,0,j);
            if(board[rows-1][j] == 'O') dfs(board,rows-1,j);
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j]=='O') board[i][j]='X';
                else if(board[i][j]=='Y') board[i][j]='O';
            }
        }
        return ;
    }

    public void dfs(char[][] board, int i, int j){
        board[i][j] = 'Y';
        for(int[] dir : directions){
            int x = i + dir[0];
            int y = j + dir[1];
            if(x<0 || y<0 || x>=board.length || y>=board[0].length || board[x][y]=='Y' || board[x][y]=='X') continue;
            dfs(board,x,y);
        }
    }
}