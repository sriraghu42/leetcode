class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        if(nums[len-1]>=nums[0]) return nums[0];
        int i = 0;
        int j = len-1;
        while(i<=j){
            int k = i+(j-i)/2;
            if(k==0) return nums[i+1];
            if(k==len-1) return nums[len-1];
            if(nums[k]<nums[k-1] && nums[k]<nums[k+1]) return nums[k];
            if(nums[k]>nums[0]) i=k+1;
            else j=k-1;
        }
        return -1;
    }
}