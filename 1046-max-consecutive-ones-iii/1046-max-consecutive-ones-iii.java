class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int i = 0;
        int j = 0;
        int zeroCount = 0;
        while(j<nums.length){
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