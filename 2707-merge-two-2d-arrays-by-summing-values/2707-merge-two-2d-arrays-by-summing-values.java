class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums1.length; i++){
            map.put(nums1[i][0],nums1[i][1]);
        }
        for(int i=0; i<nums2.length; i++){
            map.put(nums2[i][0],map.getOrDefault(nums2[i][0],0)+nums2[i][1]);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a,b) -> a.getKey()-b.getKey());
        int[][] ans = new int[list.size()][2];
        for(int i=0; i<ans.length; i++){
            ans[i][0] = list.get(i).getKey();
            ans[i][1] = list.get(i).getValue();
        }
        return ans;
    }
}