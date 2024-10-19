class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<Pair> pq = new PriorityQueue<>((a,b) -> b.k - a.k);
        for(int i=0; i<points.length; i++){
            int[] point = points[i];
            int dist = point[0]*point[0] + point[1]*point[1];
            pq.offer(new Pair(point,dist));
            if(pq.size()>k) pq.poll();
        }
        int[][] ans = new int[k][2];
        int a = 0;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            ans[a] = p.arr;
            a++;
        }
        return ans;
    }
}

class Pair{
    int[] arr;
    int k;
    Pair(int[] arr, int k){
        this.arr = arr;
        this.k = k;
    }
}