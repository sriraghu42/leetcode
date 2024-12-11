class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int counter = 1;
        int ans = 1;
        int i = 0;
        int j = 1;
        while(j<nums.length){
            ans = Math.max(ans,j-i);
            while(Math.abs(nums[j]-nums[i])>2*k){
                i++;
            }
            j++;
        }
        ans = Math.max(ans,j-i);
        return ans;
    }
}