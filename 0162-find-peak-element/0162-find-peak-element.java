class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if(len==1) return 0;;
        if(nums[0]>nums[1]) return 0;
        if(nums[len-2]<nums[len-1]) return len-1;
        int i = 0;
        int j = len-1;
        while(i<=j){
            int k = i+(j-i/2);
            if(nums[k-1]<nums[k] && nums[k]>nums[k+1]) return k;
            if(nums[k]>nums[k-1]) i=k+1;
            else j=k-1;
        }
        return -1;
    }
}