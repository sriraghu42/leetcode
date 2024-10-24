class Solution {
    public int arrangeCoins(int n) {
        int i = 0;
        int j = n;
        while(i<=j){
            int k = i + (j-i)/2;
            long sum = (long) k * (k+1)/2;
            if(sum>n) j = k-1;
            else if(sum<n) i=k+1;
            else return k;
        }
        return j;
    }
}