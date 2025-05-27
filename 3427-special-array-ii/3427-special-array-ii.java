class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] pf = new int[nums.length];
        int counter = 0;
        for(int i=1; i<nums.length; i++){
            if(Math.abs(nums[i]-nums[i-1])%2!=0) counter++;
            pf[i] = counter;
        }
        boolean[] ans = new boolean[queries.length];
        for(int i=0; i<queries.length; i++){
            int[] query = queries[i];
            if(pf[query[1]]-pf[query[0]]==query[1]-query[0]) ans[i] = true;
        }
        return ans;
    }
}
