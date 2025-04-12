class Solution {
    public long countSubarrays(int[] nums, long k) {
        long ans = 0;
        int left = 0;
        int right = 0;
        long sum = 0;
        while(right<nums.length){
            sum+= nums[right];
            while(left<=right && sum * (right-left+1)>=k){
                sum-=nums[left];
                left++;
            }
            ans+=(right-left+1);
            right++;
        }
        return ans;
    }
}