class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long i = 1;
        Arrays.sort(piles);
        long j = piles[piles.length-1];
        while(i<=j){
            long count = 0;
            long k = (i+j)/2;
            //System.out.println("k : "+k);
            for(int pile : piles){
                long div = pile/k;
                long rem = pile%k;
                count+=div+(rem!=0?1:0);
            }
            //System.out.println("count : "+count);
            if(count<=h) j=k-1;
            else i=k+1;
        }
        return (int) i;
    }
}