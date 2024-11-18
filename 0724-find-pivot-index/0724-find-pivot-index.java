class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
        }
        int prefixSum = 0;
        for(int i=0; i<nums.length; i++){
            sum-=nums[i];
            if(prefixSum == sum) return i;
            prefixSum+=nums[i];
        }
        return -1;
    }
}