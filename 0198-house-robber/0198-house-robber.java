class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    int[] nums;
    public int rob(int[] nums) {
        this.nums = nums;
        return dp(nums.length-1);
    }

    public int dp(int n){
        if(n==0) return nums[0];
        if(n==1) return Math.max(nums[0],nums[1]);
        if(map.containsKey(n)) return map.get(n);
        map.put(n,Math.max(nums[n]+dp(n-2),dp(n-1)));
        return map.get(n);
    }
}