class Solution {
    public int waysToSplitArray(int[] nums) {
        long[] front  = new long[nums.length];
        long[] back = new long[nums.length];
        long sum = 0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            front[i] = sum;
        }
        sum = 0;
        for(int i=nums.length-1; i>=0; i--){
            sum+=nums[i];
            back[i] = sum;
        }
        int ans = 0;
        for(int i=0; i<nums.length-1; i++){
            if(front[i]>=back[i+1]) ans++;
        }
        return ans;
    }
}