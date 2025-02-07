class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int[] ans = new int[queries.length];
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        for(int i=0; i<queries.length; i++){
            int[] query = queries[i];
            int x  = query[0];
            int y = query[1];
            if(map1.containsKey(x)){
                int z = map1.get(x);
                map2.put(z,map2.get(z)-1);
                if(map2.get(z)==0) map2.remove(z);
            }
            map1.put(x,y);
            map2.put(y,map2.getOrDefault(y,0)+1);
            ans[i] = map2.size();
        }
        return ans;
    }
}
