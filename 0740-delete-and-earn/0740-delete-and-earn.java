class Solution {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        //Map<Integer,Integer> map = new HashMap<>();
        int[] arr = new int[(int) Math.pow(10,4)+1];
        for(int num : nums){
            //map.put(num,map.getOrDefault(num,0)+1);
            arr[num]++;
        }
        int min = nums[0];
        int max = nums[nums.length-1];
        int[] dp = new int[max+1];
        dp[min] = min * arr[min];
        if(max>min){
            //dp[min+1] = Math.max(dp[min],(min+1)*map.get(min+1));
            for(int i=min+1; i<=max; i++){
                dp[i] = Math.max(dp[i-1],dp[i-2]+i*arr[i]);
                //if(map.containsKey(i)) dp[i] = Math.max(dp[i-1],dp[i-2]+i*map.get(i));
                //else dp[i] = dp[i-1];
            }
        }
        return dp[max];
    }
}