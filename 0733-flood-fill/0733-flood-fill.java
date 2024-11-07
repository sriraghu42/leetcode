class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int val = image[sr][sc];
        int rows = image.length;
        int cols = image[0].length;
        boolean visited[][]= new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {sr,sc});
        while(!q.isEmpty()){
            int[] cell = q.poll();
            int i = cell[0];
            int j = cell[1];
            if(i<0 || i>=rows || j<0 || j>=cols) continue;
            if(visited[i][j]) continue;
            if(image[i][j]!=val) continue;
            image[i][j] = color;
            visited[i][j] = true;
            q.offer(new int[] {i-1,j});
            q.offer(new int[] {i+1,j});
            q.offer(new int[] {i,j-1});
            q.offer(new int[] {i,j+1});
        }
        return image;
    }
}