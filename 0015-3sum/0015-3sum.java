class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i-1]==nums[i]) continue;
            int target = 0 - nums[i];
            int j = i+1;
            int k = len-1;
            while(j<k){
                if(nums[j]+nums[k] == target){
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while(j<k && nums[j+1]==nums[j]) j++;
                    while(j<k && nums[k-1]==nums[k]) k--;
                    j++;
                    k--;
                }
                else if(nums[j]+nums[k]>target){
                    k--;
                }
                else j++;
            }
        }
        return ans;
    }
}
