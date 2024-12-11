class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int counter = 1;
        int ans = 1;
        int i = 0;
        int j = 1;
        while(j<nums.length){
            if(Math.abs(nums[j]-nums[i])<=2*k) ans = Math.max(ans,j-i+1);
            else{
                while(Math.abs(nums[j]-nums[i])>2*k){
                    i++;
                }
            }  
            j++;
        }
        return ans;
    }
}