class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0;
        long maxSum = 0;
        Set<Integer> set = new HashSet<>();
        int i = 0;
        int j = 0;
        while(j<nums.length){
            while(i<nums.length && set.contains(nums[j])){
                sum-=nums[i];
                set.remove(nums[i]);
                i++;
            }
            sum+=nums[j];
            set.add(nums[j]);
            if(j-i+1==k){
                maxSum = Math.max(maxSum,sum);
                sum-=nums[i];
                set.remove(nums[i]);
                i++;
            } 
            j++;
        }
        return maxSum;
    }
}