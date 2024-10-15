class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> {
            int comp = b[1]-a[1];
            if(comp!=0) return comp;
            return b[0]-a[0];
        });
        
        for(int i=0; i<mat.length; i++){
            int[] row = mat[i];
            int m=0;
            int n=row.length-1;
            while(m<=n){
                int p = m+(n-m)/2;
                if(row[p]==1) m=p+1;
                else n=p-1;
            }
            pq.offer(new int[] {i,m});
            if(pq.size()>k) pq.poll();
        }

        int[] ans = new int[k];
        for(int i=k-1; i>=0; i--){
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}