class Solution {
    public int search(int[] nums, int target) {
        int last = nums.length-1;
        int i = 0;
        int j = nums.length-1;
        while(i<=j){
            int k = i+(j-i)/2;
            if(target==nums[k]) return k;
            if(target<=nums[last]){
                if(nums[k]>nums[last]) i=k+1;
                else{
                    if(nums[k]>target) j=k-1;
                    else i=k+1;
                }
            }
            else{
                if(nums[k]<nums[last]) j=k-1;
                else{
                    if(nums[k]>target) j=k-1;
                    else i=k+1;
                }
            }
        }
        return -1;
    }
}