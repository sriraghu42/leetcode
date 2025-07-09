class Solution {
    
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for(int num : nums) sum+=num;
        if(sum%2!=0) return false;
        int target = sum/2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true; 
        int pos = len-1;
        while(pos>=0){
            for(int j=target; j>=0; j--){
                dp[j] = dp[j] || (j-nums[pos]>=0 && dp[j-nums[pos]]);
            }
            pos--;
        }
        return dp[target];
    }

}