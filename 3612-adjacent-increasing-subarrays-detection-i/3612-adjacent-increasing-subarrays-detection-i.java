class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        if(k==1) return true;
        int i = 0;
        int size = nums.size();
        int j = 1;
        Set<Integer> set = new HashSet<>();
        while(j<size){
            if(nums.get(j)<=nums.get(j-1)) i=j;
            else{
                if(nums.get(j)>nums.get(j-1) && j-i+1==k){
                    set.add(i);
                    i++;
                }
            }
            j++;
        }
        for(int num : set){
            if(set.contains(k+num)) return true;
        }
        return false;
    }
}