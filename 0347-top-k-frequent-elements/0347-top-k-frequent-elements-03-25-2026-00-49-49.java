class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<int[]> freqList = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            freqList.add(new int[] {entry.getKey(),entry.getValue()});
        }
        freqList.sort((a,b)->b[1]-a[1]);
        int[] ans = new int[k];
        for(int i=0; i<k; i++){
            ans[i]=freqList.get(i)[0];
        }
        return ans;
    }
}

/*
1->4
2->2
5->5
6->1

4,2,5,1
*/