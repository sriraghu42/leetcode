class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int i = 1;
        int j = arr.length-2;
        while(i<j){
            int k = i+(j-i)/2;
            if(arr[k]>arr[k-1] && arr[k]>arr[k+1]) return k;
            if(arr[k]>arr[k-1]) i=k+1;
            else j=k-1;
        }
        return i;
    }
}