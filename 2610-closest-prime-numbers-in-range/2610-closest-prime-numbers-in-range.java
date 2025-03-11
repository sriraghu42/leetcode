class Solution {
    public int[] closestPrimes(int left, int right) {
        int[] sieve = new int[right+1];
        Arrays.fill(sieve,1);
        sieve[0] = 0;
        sieve[1] = 0;
        for(int i=2; i<right+1; i++){
            if(sieve[i]!=0){
                for(int k=2; k*i<=right; k++){
                    sieve[k*i] = 0;
                }
            }
        }
        int[] ans = new int[2];
        Arrays.fill(ans,-1);
        int prev = -1;
        int min = Integer.MAX_VALUE;
        for(int i=left; i<=right; i++){
            if(sieve[i]==1){
                if(prev == -1) ;
                else{
                    if(i-prev<min){
                        ans[0] = prev;
                        ans[1] = i;
                        min = i-prev;
                    }
                }
                prev = i;
            }
        }
        return ans;
    }
}