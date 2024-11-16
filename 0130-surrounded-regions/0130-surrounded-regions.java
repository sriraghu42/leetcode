class Solution {
    int[][] directions = new int[][] {{-1,0},{1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] marked = new boolean[rows][cols];
        for(int i=0; i<rows; i++){
            if(board[i][0] == 'O') dfs(board,i,0,marked);
            if(board[i][cols-1] == 'O') dfs(board,i,cols-1,marked);
        }
        for(int j=0; j<cols; j++){
            if(board[0][j] == 'O') dfs(board,0,j,marked);
            if(board[rows-1][j] == 'O') dfs(board,rows-1,j,marked);
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j]=='O' && !marked[i][j]) board[i][j]='X';
            }
        }
        return ;
    }

    public void dfs(char[][] board, int i, int j, boolean[][] marked){
        marked[i][j] = true;
        for(int[] dir : directions){
            int x = i + dir[0];
            int y = j + dir[1];
            if(x<0 || y<0 || x>=board.length || y>=board[0].length || marked[x][y] || board[x][y]=='X') continue;
            dfs(board,x,y,marked);
        }
    }
}