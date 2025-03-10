class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int ans = 0;
        for(int num : nums){
            sum+=num;
            int value = sum - k;
            if(map.containsKey(value)) ans+=map.get(value);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}