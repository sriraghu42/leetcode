class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] front = new int[n];
        int[] back = new int[n];
        int product = 1;
        for(int i=0; i<n; i++){
            product*=nums[i];
            front[i] = product;
        }
        product = 1;
        for(int i=n-1; i>=0; i--){
            product*=nums[i];
            back[i] = product;
        }
        int[] ans = new int[n];
        ans[0] = back[1];
        if(n>1) ans[n-1] = front[n-2];
        for(int i=1; i<n-1; i++){
            ans[i] = front[i-1]*back[i+1];
        }
        return ans;
    }
}