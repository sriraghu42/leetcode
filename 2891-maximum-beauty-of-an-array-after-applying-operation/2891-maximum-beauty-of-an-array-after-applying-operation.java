class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int ans = 0;
        Arrays.sort(nums);
        int i = 0;
        int j = 0;
        int len = nums.length;
        while(j<len){
            while(nums[j]-nums[i]>2*k){
                i++;
            }
            ans = Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}
