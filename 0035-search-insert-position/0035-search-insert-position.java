class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length-1;
        while(i<=j){
            int k = i + (j-i)/2;
            if(nums[k]==target) return k;
            if(nums[k]<target) i=k+1;
            else j=k-1;
        }
        return i;
    }
}