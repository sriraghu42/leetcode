class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums) map.put(num,map.getOrDefault(num,0)+1);
        List<List<Integer>> buckets = new ArrayList<>();
        for(int i=0; i<nums.length+1; i++) buckets.add(new ArrayList<>());
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            buckets.get(entry.getValue()).add(entry.getKey());
        }
        int[] ans = new int[k];
        int counter = 0;
        for(int i=nums.length; i>=0 && counter<k; i--){
            if(!buckets.get(i).isEmpty()){
                for(int num : buckets.get(i)){
                    ans[counter] = num;
                    counter++;
                    if(counter==k) break;
                }
            }
        }
        return ans;
    }
}
