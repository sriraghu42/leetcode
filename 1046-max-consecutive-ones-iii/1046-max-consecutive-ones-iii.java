class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int i = 0;
        int j = 0;
        int[] a = new int[2];
        while(j<nums.length){
            a[nums[j]]++;
            if(a[0]>k){
                //ans = Math.max(ans,a[1]+k);
                while(a[0]>k){
                    a[nums[i]]--;
                    i++;
                }
            }
            ans = Math.max(ans,a[1]+a[0]);
            j++; 
        }
        return ans;
    }
}