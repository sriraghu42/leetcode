class Solution {
    int[] arr;
    public int tribonacci(int n) {
        this.arr = new int[n+1];
        Arrays.fill(arr,-1);
        return dp(n);
    }

    public int dp(int n){
        if(n==0) return 0;
        if(n==1 || n==2) return 1;
        if(arr[n]==-1) arr[n] = dp(n-1)+dp(n-2)+dp(n-3);
        return arr[n];
    }
}