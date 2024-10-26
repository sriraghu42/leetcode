class Solution {
    public int deleteAndEarn(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        int[] arr = new int[(int) Math.pow(10,4)+1];
        for(int num : nums){
            min = Math.min(min,num);
            max = Math.max(max,num);
            arr[num]++;
        }
        int[] dp = new int[max+1];
        dp[min] = min * arr[min];
        for(int i=min+1; i<=max; i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+i*arr[i]);
        }
        return dp[max];
    }
}