class Solution {
    public long repairCars(int[] ranks, int cars) {
        Arrays.sort(ranks);
        int minValue = ranks[0];
        long j = (long) cars * cars * minValue;
        long i = 1;
        while(i<=j){
            long k = i+(j-i)/2;
            //System.out.println("k :"+k);
            long count = 0;
            for(int rank : ranks){
                count+= (int) Math.sqrt(k/rank);
            }
            //System.out.println("count :"+count);
            if(count>=cars) j=k-1;
            else i=k+1;
        }
        return i;
    }
}
