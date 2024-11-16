class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        Arrays.fill(ans,-1);
        for(int i=0; i<=nums.length-k; i++){
            if(checkOrder(nums,k,i)) ans[i] = nums[i+k-1];
            else ans[i] = -1;
        }
        return ans;
    }

    public boolean checkOrder(int[] nums, int k, int m){
        for(int i=m+1; i<m+k; i++){
            if(nums[i]!=nums[i-1]+1) return false;
        }
        return true;
    }
}