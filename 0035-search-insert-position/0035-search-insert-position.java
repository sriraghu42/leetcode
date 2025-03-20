class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length-1;
        while(i<=j){
            int k = (i+j)/2;
            if(nums[k]==target) return k;
            else if(nums[k]>target) j--;
            else i++;
        }
        return i;
    }
}