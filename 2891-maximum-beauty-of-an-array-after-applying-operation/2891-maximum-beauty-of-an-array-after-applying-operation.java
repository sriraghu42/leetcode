class Solution {
    public int maximumBeauty(int[] nums, int k) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int num : nums){
            map.put(num-k, map.getOrDefault(num-k,0)+1);
            map.put(num+k+1, map.getOrDefault(num+k+1,0)-1);
        }
        int count = 0;
        int ans = 0;
        for(int value : map.values()){
            count+=value;
            ans = Math.max(ans,count);
        }
        return ans;
    }
}

/*
1 3
0 2
2 4
0 1 0 0 -1 0
1 0 0 -1 0 0
0 0 1 0  1 -1

1 1 1 -1 0 -1
1 2 3 2 2 3
*/