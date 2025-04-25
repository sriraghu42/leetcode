class Solution {
    int[][] directions = new int[][] {{-1,0},{1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j]==word.charAt(0)){
                    boolean[][] visited = new boolean[rows][cols];
                    if(dfs(board,word,i,j,visited,1,rows,cols)) return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, boolean[][] visited,int index, int rows, int cols){
        if(index==word.length()) return true;
        visited[i][j] = true;
        for(int[] dir : directions){
            int x = i + dir[0];
            int y = j + dir[1];
            if(x<0 || y<0 || x>=rows || y>=cols || visited[x][y] || board[x][y]!=word.charAt(index)) continue;
            if(dfs(board,word,x,y,visited,index+1,rows,cols)) return true;
            visited[x][y] = false;
        }
        visited[i][j] = false;
        return false;
    }
}