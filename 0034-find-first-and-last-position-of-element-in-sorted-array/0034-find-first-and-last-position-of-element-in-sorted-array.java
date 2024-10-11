class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0]=-1;
        ans[1]=-1;
        int i = 0;
        int j = nums.length-1;
        boolean found = false;
        while(i<=j){
            int k = i+(j-i)/2;
            if(nums[k]>target) j=k-1;
            else if(nums[k]==target){
                found = true;
                j=k-1;
            }
            else i=k+1;
        }
        if(found){
            int m = i;
            while(m<nums.length-1 && nums[m]==nums[m+1]) m++;
            ans[0] = i;
            ans[1] = m;
        }
        return ans;
    }
}