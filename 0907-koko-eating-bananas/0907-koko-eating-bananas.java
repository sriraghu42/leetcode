class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long i = 1;
        long j = (long) Math.pow(10,9);
        while(i<j){
            long k = i+(j-i)/2;
            long counter = 0;
            for(int pile : piles){
                long a = pile/k;
                long b = pile%k;
                if(b>0) counter+=a+1;
                else counter+=a;
            }
            if(counter>h) i=k+1;
            else j=k;
        }
        return (int)i;
    }
}