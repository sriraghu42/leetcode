class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                char ch = board[i][j];
                if(helperRec(board,word,0,i,j)) return true;
            }
        }
        return false;
    }

    public boolean helperRec(char[][] board, String word, int index, int i, int j){
        if(index==word.length()) return true;
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1) return false;
        if(board[i][j]=='#') return false;
        if(board[i][j]==word.charAt(index)){
            char temp = board[i][j];
            board[i][j] = '#';
            boolean ans = helperRec(board,word,index+1,i-1,j) || helperRec(board,word,index+1,i+1,j)
                    || helperRec(board,word,index+1,i,j-1) || helperRec(board,word,index+1,i,j+1);
            board[i][j] = temp;
            return ans;
        }
        return false;
    }
}