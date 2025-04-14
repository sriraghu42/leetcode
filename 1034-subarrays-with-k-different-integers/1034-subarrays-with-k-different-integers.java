class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subArrayswithAtmost(nums,k)-subArrayswithAtmost(nums,k-1);
    }

    public int subArrayswithAtmost(int[] nums, int k){
        if(k==0) return 0;
        else{
            int count = 0;
            int left = 0;
            int right = 0;
            Map<Integer,Integer> map = new HashMap<>();
            while(right<nums.length){
                int num = nums[right];
                map.put(num,map.getOrDefault(num,0)+1);
                while(left<=right && map.size()>k){
                    int leftNum = nums[left];
                    map.put(leftNum,map.get(leftNum)-1);
                    if(map.get(leftNum)==0) map.remove(leftNum);
                    left++;
                }
                count+=(right-left+1);
                right++;
            }
            return count;
        }
    }
}