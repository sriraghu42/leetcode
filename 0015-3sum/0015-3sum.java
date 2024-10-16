class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            int target = 0 - nums[i];
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                int sum = nums[j] + nums[k];
                if(target<sum) k--;
                else if(target>sum) j++;
                else{
                    set.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                }
            }
        }
        return new ArrayList<>(set);
    }
}