class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        if(n==1) return 0;
        long totalPairs = ((long) n*(n-1))/2;
        long count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int modiN = nums[i]-i;
            map.put(modiN,map.getOrDefault(modiN,0)+1);
        }
        for(int value : map.values()){
            if(value<2) continue;
            else if(value==2) count++;
            else count+= ((long) value * (value-1)/2) ;
        }
        return totalPairs-count;
    }

}