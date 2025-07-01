class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if(len==0) return new int[] {-1,-1};
        int i = 0;
        int j = len-1;
        while(i<=j){
            int k = i+(j-i)/2;
            if(nums[k]>=target) j=k-1;
            else i=k+1;
        }
        if(i>=len || nums[i]!=target) return new int[] {-1,-1};
        int k=i;
        while(k<len && nums[i]==nums[k]) k++;
        return new int[] {i,k-1};
    }
}