class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean visited[][]= new boolean[image.length][image[0].length];
        helperRec(image,sr,sc,image[sr][sc],color,visited);
        return image;
    }

    public void helperRec(int[][] image, int i, int j, int val, int color, boolean[][] visited){
        if(i<0 || i>=image.length || j<0 || j>=image[0].length) return;
        if(visited[i][j]) return;
        if(image[i][j]!=val) return;
        image[i][j] = color;
        visited[i][j] = true;
        helperRec(image,i-1,j,val,color,visited);
        helperRec(image,i+1,j,val,color,visited);
        helperRec(image,i,j-1,val,color,visited);
        helperRec(image,i,j+1,val,color,visited);
    }
}