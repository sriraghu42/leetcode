class Solution {
    int[][] directions = new int[][] {{-1,0},{1,0},{0,1},{0,-1}};
    int ans = Integer.MAX_VALUE;

    public int minTimeToReach(int[][] moveTime) {
        int rows = moveTime.length;
        int cols = moveTime[0].length;
        boolean[][] visited = new boolean[rows][cols];
        visited[0][0] = true;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.offer(new int[] {0,0,0});
        while(!pq.isEmpty()){
            int[] cell = pq.poll();
            if(cell[0]==rows-1 && cell[1]==cols-1) return cell[2];
            for(int[] dir : directions){
                int a = cell[0] + dir[0];
                int b = cell[1] + dir[1];
                if(a<0 || a>=rows || b<0 || b>=cols || visited[a][b]) continue;
                visited[a][b] = true;
                int time = cell[2]+1+Math.max(0,moveTime[a][b]-cell[2]);
                pq.offer(new int[] {a,b,time});
            }
        }
        return 0;
    }
}