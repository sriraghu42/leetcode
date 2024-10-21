class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> {
            int compValue = b[1]-a[1];
            if(compValue!=0) return compValue;
            return b[0]-a[0];});
        for(int i=0; i<mat.length; i++){
            int[] arr = mat[i];
            int m = 0;
            int n = arr.length-1;
            while(m<=n){
                int p = m+(n-m)/2;
                if(arr[p]==1) m=p+1;
                else n=p-1;
            }
            pq.offer(new int[] {i,n+1});
            if(pq.size()>k) pq.poll();
        }
        int[] ans = new int[k];
        for(int i=k-1; i>=0; i--){
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}