class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.add(new int[] {entry.getKey(),entry.getValue()});
            if(pq.size()>k) pq.poll();
        }
        int[] ans = new int[k];
        for(int i=0; i<k; i++){
            ans[i]=pq.poll()[0];
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