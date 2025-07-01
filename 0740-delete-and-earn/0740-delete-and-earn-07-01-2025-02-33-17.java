class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] arr = new int[10001];
        int max = 0;
        for(int num : nums){
            max = Math.max(num,max);
            arr[num]+=num;
        } 
        int[] dp = new int[max+1];
        dp[0] = 0;
        dp[1] = Math.max(dp[0],arr[1]);
        for(int i=2; i<dp.length; i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+arr[i]);
            //System.out.println(dp[i]);
        }
        return dp[max];
    }
}

