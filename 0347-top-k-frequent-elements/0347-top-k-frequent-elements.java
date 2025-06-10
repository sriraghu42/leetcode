class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums) map.put(num,map.getOrDefault(num,0)+1);
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a,b) -> b.getValue()-a.getValue());
        int[] ans = new int[k];
        for(int i=0; i<ans.length; i++) ans[i] = list.get(i).getKey();
        return ans;
    }
}
