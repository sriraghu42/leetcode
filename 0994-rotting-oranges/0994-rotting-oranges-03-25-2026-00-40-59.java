class Solution {
    int freshCount = 0;
    int[][] directions = new int[][] {{-1,0},{1,0},{0,1},{0,-1}};
    public int orangesRotting(int[][] grid) {
        int rowLength = grid.length; 
        int colLength = grid[0].length;
        Queue<int[]> rotQueue = new LinkedList<>();
        for(int row = 0; row<rowLength; row++){
            for(int col=0; col<colLength; col++){
                if(grid[row][col]==1) freshCount++;
                else if(grid[row][col]==2){
                    rotQueue.add(new int[] {row,col});
                }
            }
        }
        //System.out.println("size:"+rotQueue.size());
        if(freshCount==0) return 0;
        if(rotQueue.size()==0) return -1;
        int time = 0;
        while(!rotQueue.isEmpty() && freshCount!=0){
            int len = rotQueue.size();
            time++;
            for(int i=0; i<len; i++){
                int[] rotCurr = rotQueue.poll();
                for(int[] dir:directions){
                    int x = rotCurr[0]+dir[0];
                    int y = rotCurr[1]+dir[1];
                    if(x<0 || x>=rowLength || y<0 || y>=colLength || grid[x][y]!=1) continue;
                    grid[x][y]=2;
                    freshCount--;
                    rotQueue.add(new int[] {x,y});
                }
            }
        }
        if(freshCount!=0) return -1;
        return time;
    }
}