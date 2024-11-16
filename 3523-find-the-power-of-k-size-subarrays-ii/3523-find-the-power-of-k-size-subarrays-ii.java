class Solution {
    public int[] resultsArray(int[] nums, int k) {
        if(k==1) return nums;
        int[] ans = new int[nums.length-k+1];
        Arrays.fill(ans,-1);
        int i = 0;
        int j = 1;
        while(j<nums.length){
            if(nums[j]!=nums[j-1]+1) i = j;
            else{
                if(j-i+1==k){
                    ans[i] = nums[j];
                    i++;
                }
            }
            j++;
        }
        return ans;
    }
}