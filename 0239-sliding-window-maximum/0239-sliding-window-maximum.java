class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int i=0;
        int j=0;
        int[] ans = new int[nums.length-k+1];
        while(j<nums.length){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            if(j-i+1==k){
                ans[i] = map.lastKey();
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i])==0) map.remove(nums[i]);
                i++;
            }
            j++;
        }
        return ans;
    }
}