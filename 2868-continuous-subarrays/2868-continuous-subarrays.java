class Solution {
    public long continuousSubarrays(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int i = 0;
        int j = 0;
        int len = nums.length;
        long ans = 0;
        while(j<len){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(Math.abs(map.firstKey()-map.lastKey())>2){
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i])==0) map.remove(nums[i]);
                i++;
            }
            ans+=j-i+1;
            j++;
        }
        return ans;
    }
}