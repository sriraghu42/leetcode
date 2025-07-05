class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] arr = new int[1002];
        for(int[] trip : trips){
            int persons = trip[0];
            arr[trip[1]]+=persons;
            arr[trip[2]]-=persons;
        }
        if(arr[0]>capacity) return false;
        for(int i=1; i<1002; i++){
            arr[i]+=arr[i-1];
            if(arr[i]>capacity) return false;
        }
        return true;
    }
}
/*
1 2 3 4 5 6  7 8
2       3 -2   -3
2 2 2 2 5 3  3 0
*/
