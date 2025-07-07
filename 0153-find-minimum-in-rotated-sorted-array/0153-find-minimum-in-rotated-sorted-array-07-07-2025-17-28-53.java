class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        if(len==1 || nums[len-1]>nums[0]) return nums[0];
        int i = 0;
        int j = len-1;
        while(i<=j){
            int k = i+(j-i)/2;
            if(nums[k]>=nums[0]) i=k+1;
            else j=k-1;
        }
        return nums[i];
    }
}