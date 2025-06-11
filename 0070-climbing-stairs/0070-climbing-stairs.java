class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public int climbStairs(int n) {
        return dfs(0,n);
    }

    public int dfs(int sum, int n){
        if(map.containsKey(sum)) return map.get(sum);
        if(sum==n) return 1;
        if(sum>n) return 0;
        int ways = dfs(sum+1,n) + dfs(sum+2,n);
        map.put(sum,ways);
        return ways;
    }
}