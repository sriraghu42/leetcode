class Solution {
    public long countSubarrays(int[] nums, long k) {
        long sum = 0;
        int i = 0;
        int j = 0;
        long ans = 0;
        while(j<nums.length){
            sum+=nums[j];
            while(i<=j && sum*(j-i+1)>=k){
                sum-=nums[i];
                i++;
            }
            if(sum*(j-i+1)<k) ans+=j-i+1;
            j++;
        }
        return ans;
    }
}