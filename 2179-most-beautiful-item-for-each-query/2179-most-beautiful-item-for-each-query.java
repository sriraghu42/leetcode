class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items,(a,b) -> a[0]-b[0]);
        int max = 0;
        for(int[] item : items){
            max = Math.max(max,item[1]);
            item[1] = max;
        }
        int len = queries.length;
        int[] ans = new int[len];
        for(int i=0; i<queries.length; i++){
            ans[i] = compute(items,queries[i]);
        }
        return ans;
    }

    public int compute(int[][] items, int query){
        int i = 0;
        int j = items.length-1;
        while(i<=j){
            int k = i+(j-i)/2;
            if(items[k][0]<=query) i=k+1;
            else j=k-1;
        }
        return j==-1?0:items[j][1];
    }
}