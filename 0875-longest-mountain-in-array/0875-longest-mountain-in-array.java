class Solution {
    public int longestMountain(int[] arr) {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        int min = 0;
        left[0] = 0;
        for(int i=1; i<arr.length; i++){
            if(arr[i]<=arr[i-1]){
                min = i;
            }
            left[i] = min;
        }
        int max = arr.length-1;
        right[arr.length-1] = max;
        for(int i=arr.length-2; i>=0; i--){
            if(arr[i]<=arr[i+1]){
                max = i;
            }
            right[i] = max;
        }
        int ans = 0;
        for(int i=0; i<arr.length; i++){
            if(i!=left[i] && i!=right[i]){
                ans = Math.max(ans,right[i]-left[i]+1);
            }
        }
        return ans;
    }
}

/*
2 - 2
1 - 1
4 - 1
7 - 1
3 - 3
2 - 2
5 - 2
*/