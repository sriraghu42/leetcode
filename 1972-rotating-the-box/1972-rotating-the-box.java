class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int rows = boxGrid.length; //3
        int cols = boxGrid[0].length; //6
        char[][] ans = new char[cols][rows];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                ans[j][rows-1-i] = boxGrid[i][j];
            }
        }
        int k = 0;
        while(k<rows){
            int obst = cols;
            for(int m = cols-1; m>=0; m--){
                if(ans[m][k]=='#'){
                    ans[m][k]='.';
                    ans[obst-1][k] = '#';
                    obst = obst-1;
                }
                else if(ans[m][k]=='*'){
                    obst = m;
                }
            }
            k++;
        }

        return ans;
    }
}