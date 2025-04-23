class Solution {
    public int findMin(int[] nums) {
        if(nums[nums.length-1]>=nums[0]) return nums[0];
        int len = nums.length;
        int i = 0;
        int j = len-1;
        while(i<=j){
            int k = i+(j-i)/2;
            if (nums[k]>=nums[0]) i=k+1;
            else j=k-1;
        }
        return nums[i];
    }
}