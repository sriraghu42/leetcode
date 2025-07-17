class Solution {
    int rowLength;
    int colLength;
    int len;
    int[][] directions = new int[][] {{-1,0},{1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        rowLength = board.length;
        colLength = board[0].length;
        len = word.length();
        for(int i=0; i<rowLength; i++){
            for(int j=0; j<colLength; j++){
                if(board[i][j]==word.charAt(0)){
                    boolean[][] visited = new boolean[rowLength][colLength];
                    if(helperRec(board,word,visited,i,j,0)) return true;
                }
            }
        }
        return false;
    }

    public boolean helperRec(char[][] board, String word, boolean[][] visited, int row, int col, int pos ){
        if(pos==len-1) return true;
        visited[row][col] = true;
        for(int[] dir : directions){
            int x = row + dir[0];
            int y = col + dir[1];
            if(x<0 || x>=rowLength || y<0 || y>=colLength || visited[x][y] || board[x][y]!=word.charAt(pos+1)) continue;
            if(helperRec(board,word,visited,x,y,pos+1)) return true;
        }
        visited[row][col] = false;
        return false;
    }
}