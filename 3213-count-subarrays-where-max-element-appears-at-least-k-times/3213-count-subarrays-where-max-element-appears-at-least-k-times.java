class Solution {
    public long countSubarrays(int[] nums, int k) {
        int count = 0;
        int maxNum = -1;
        for(int num : nums) maxNum = Math.max(maxNum,num);
        int i = 0;
        int j = 0;
        long ans = 0;
        while(j<nums.length){
            if(nums[j]==maxNum) count++;
            while(i<=j && count==k){
                ans+=nums.length-j;
                if(nums[i]==maxNum) count--;
                i++;
            }
            j++;
        }
        return ans;
    }
}