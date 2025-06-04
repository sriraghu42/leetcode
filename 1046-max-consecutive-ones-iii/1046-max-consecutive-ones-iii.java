class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeroCount = 0;
        int len = nums.length;
        int i = 0; 
        int j = 0;
        int ans = 0;
        while(j<len){
            if(nums[j]==0) zeroCount++;
            while(zeroCount>k){
                if(nums[i]==0) zeroCount--;
                i++;
            }
            ans = Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}