class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] arr = new int[1002];
        for(int[] trip : trips){
            arr[trip[1]]+=trip[0];
            arr[trip[2]]-=trip[0];
        }
        if(arr[0]>capacity) return false;
        for(int i=1; i<1002; i++){
            arr[i]+=arr[i-1];
            if(arr[i]>capacity) return false;
        }
        return true;
    }
}