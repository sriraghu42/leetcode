class Solution {
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length-1;
        while(i<=j){
            int k = i+(j-i)/2;
            if(nums[k]==target) return k;
            if(nums[k]>=nums[i]){
                if(target>=nums[i] && target<nums[k]) j=k-1;
                else i=k+1;
            }
            else{
                if(target<=nums[j] && target>nums[k]) i=k+1;
                else j=k-1;
            }
        }
        return -1;
    }
}