class Solution {
    public int maximumCandies(int[] candies, long k) {
        int j = 0;
        for(int candy : candies) j=Math.max(j,candy);
        int i = 1;
        while(i<=j){
            int m = i + (j-i)/2;
            long count = 0;
            for(int candy : candies){
                count+=candy/m;
            }
            if(count<k) j=m-1;
            else i=m+1;
        }
        return j;
    }
}