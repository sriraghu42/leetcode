class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return b[1]-a[1];
        });

        for(int i=0; i<points.length; i++){
            int[] point = points[i];
            int dist = point[0]*point[0] + point[1]*point[1];
            pq.offer(new int[] {i,dist});
            if(pq.size()>k) pq.poll();
        }

        int[][] ans = new int[k][2];
        int j=0;
        while(!pq.isEmpty()){
            ans[j] = points[pq.poll()[0]];
            j++;
        }
        return ans;
    }
}