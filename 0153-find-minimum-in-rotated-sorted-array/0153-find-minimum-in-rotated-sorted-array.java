class Solution {
    public int findMin(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        while(i<j){
            int k = (i+j)/2;
            if(nums[k]>nums[j]) i=k+1;
            else j=k;
        }
        return nums[i];
    }
}