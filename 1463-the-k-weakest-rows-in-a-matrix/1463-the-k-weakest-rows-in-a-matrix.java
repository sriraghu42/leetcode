class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> {
            int comp = b[1]-a[1];
            if(comp!=0) return comp;
            return b[0]-a[0];
        });
        
        for(int i=0; i<mat.length; i++){
            int[] row = mat[i];
            int counter = 0;
            for(int num : row){
                if(num!=1) break;
                counter++;
            }
            pq.offer(new int[] {i,counter});
            if(pq.size()>k) pq.poll();
        }

        int[] ans = new int[k];
        for(int i=k-1; i>=0; i--){
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}