class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int counter = 0;
        for(int num : nums){
            sum+=num;
            if(map.containsKey(sum-k)) counter+=map.get(sum-k);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return counter;
    }
}