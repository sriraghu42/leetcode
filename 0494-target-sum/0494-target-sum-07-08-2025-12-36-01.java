class Solution {
    int ans = 0;
    public int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;
        helperRec(nums,len,target,0,0);
        return ans;
    }

    public void helperRec(int[] nums, int len, int target, int pos, int sum){
        if(pos==len){
            if(sum==target) ans++;
            return;
        }
        helperRec(nums,len,target,pos+1,sum+nums[pos]);
        helperRec(nums,len,target,pos+1,sum-nums[pos]);
    }
}