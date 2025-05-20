class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int len = nums.length;
        int[] calArr = new int[len];
        for(int[] query : queries){
            calArr[query[0]]++;
            if(query[1]!=len-1) calArr[query[1]+1]--;
        }
        int sum = calArr[0];
        for(int i=1; i<len; i++){
            calArr[i]+=sum;
            sum = calArr[i];
        }
        int counter = 0;
        for(int i=0; i<len; i++){
            if(nums[i]-calArr[i]<=0) counter++;
        }
        System.out.println(counter);
        return counter==len;
    }
}