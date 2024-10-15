class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> {
            int comp = a[1]-b[1];
            if(comp!=0) return comp;
            return a[0]-b[0];
        });
        int[] ans = new int[nums.length-k+1];
        Map<Integer,Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        while(j<nums.length){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            if(j-i+1==k){
                for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                    pq.offer(new int[] {entry.getKey(),entry.getValue()});
                    if(pq.size()>x) pq.poll();
                }
                while(!pq.isEmpty()){
                    int[] entry = pq.poll();
                    ans[i]+=entry[0]*entry[1];
                }
                map.put(nums[i],map.get(nums[i])-1);
                i++;
            }
            j++;
        }
        return ans;
    }
}