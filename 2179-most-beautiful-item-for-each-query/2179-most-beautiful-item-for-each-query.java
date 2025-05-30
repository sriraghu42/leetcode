class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int[] item : items){
            map.put(item[0],Math.max(map.getOrDefault(item[0],0),item[1]));
        }
        int max = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            max  = Math.max(max,entry.getValue());
            map.put(entry.getKey(),max);
        }
        int[] ans = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            Integer key = map.floorKey(queries[i]);
            if(key!=null) ans[i] = map.get(key);
            else ans[i] = 0;
        }
        return ans;
    }
}