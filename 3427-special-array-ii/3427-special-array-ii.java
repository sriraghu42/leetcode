class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] count = new int[nums.length];
        count[0] = 0;
        int counter = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[i]%2==nums[i-1]%2) counter++;
            count[i] = counter;
        }
        boolean[] ans = new boolean[queries.length];
        for(int i=0; i<queries.length; i++){
            int[] query = queries[i];
            if(count[query[1]]-count[query[0]]==0) ans[i] = true;
            else ans[i] = false;
        }
        return ans;
    }
}