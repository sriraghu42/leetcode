class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0; i<nums.length-3; i++){
            for(int j=i+1; j<nums.length-2; j++){
                long reqd = (long) target-nums[i]-nums[j];
                int m=j+1;
                int n=nums.length-1;
                while(m<n){
                    long sum = (long) nums[m] + nums[n];
                    if(reqd>sum){
                        while(m<n && nums[m]==nums[m+1]) m++;
                        m++;
                    } 
                    else if(reqd == sum){
                        set.add(Arrays.asList(nums[i],nums[j],nums[m],nums[n]));
                        while(m<n && nums[m]==nums[m+1]) m++;
                        while(m<n && nums[n]==nums[n-1]) n--;
                        m++;
                        n--;  
                    }
                    else{
                        while(m<n && nums[n]==nums[n-1]) n--;
                        n--;
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}