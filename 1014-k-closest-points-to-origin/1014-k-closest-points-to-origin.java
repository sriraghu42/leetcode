class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<>(k,(a,b)->Double.compare(b[1],a[1]));
        for(int i=0; i<points.length; i++){
            int[] point  = points[i];
            double distance = Math.sqrt(Math.pow(point[0],2)+Math.pow(point[1],2));
            pq.add(new double[] {(double) i,distance});
            if(pq.size()>k) pq.poll();
        }
        int[][] ans = new int[k][2];
        int i = 0;
        while(pq.size()>0){
            int index = (int) pq.poll()[0];
            ans[i] = points[index];
            i++;
        }
        return ans;
    }
}