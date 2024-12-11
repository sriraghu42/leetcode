class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 1;
        int i = 0;
        int j = 1;
        while(j<nums.length){
            while(Math.abs(nums[j]-nums[i])>2*k){
                i++;
            } 
            ans = Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}