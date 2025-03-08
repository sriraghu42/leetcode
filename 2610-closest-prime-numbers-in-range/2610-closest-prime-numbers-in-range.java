class Solution {
    public int[] closestPrimes(int left, int right) {
        int[] sieve = new int[right+1];
        Arrays.fill(sieve,1);
        sieve[0] = 0;
        sieve[1] = 0;
        for(int i=2; i<right+1; i++){
            if(sieve[i]==1){
                for (int k = i * 2; k <= right; k += i) {
                    sieve[k] = 0;
                }
            }
        }
        int prev = -1;
        int[] ans = new int[] {-1,-1};

        int minDiff = Integer.MAX_VALUE;
        for(int i=left; i<=right; i++){
            if(sieve[i]==1){
                if(prev!=-1 && i-prev<minDiff){
                    minDiff = i-prev;
                    ans[0] = prev;
                    ans[1] = i;
                } 
                prev = i;
            }
        }
        return ans;
    }

}


//getting all prime numbers???


//findding min diff and updating ans in loop