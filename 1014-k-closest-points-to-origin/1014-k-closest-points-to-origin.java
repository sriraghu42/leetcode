class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k,(a,b)->b[1]-a[1]);
        for(int i=0; i<points.length; i++){
            int distance = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            pq.add(new int[] {i,distance});
            if(pq.size()>k) pq.poll();
        }
        int[][] ans = new int[k][2];
        int i = 0;
        while(pq.size()>0){
            ans[i] = points[pq.poll()[0]];
            i++;
        }
        return ans;
    }
}