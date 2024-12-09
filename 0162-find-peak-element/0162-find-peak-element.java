class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        if(nums[1]<nums[0]) return 0;
        int n = nums.length;
        if(nums[n-1]>nums[n-2]) return n-1;
        int i = 1;
        int j = nums.length-2;
        while(i<j){
            int k = i+(j-i)/2;
            if(nums[k]>nums[k-1] && nums[k]>nums[k+1]) return k;
            if(nums[k]>nums[k-1]) i = k+1;
            else j=k-1;
        }
        return j;
    }
}