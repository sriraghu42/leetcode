class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[1]!=b[1]) return a[1]-b[1];
            return a[0]-b[0];
        });
        for(int i=0; i<nums.length; i++){
            pq.add(new int[] {i,nums[i]});
        }
        while(k>0){
            int[] entry = pq.poll();
            int index = entry[0];
            int value = entry[1];
            nums[index] = value * multiplier;
            k--;
            pq.add(new int[] {index,value*multiplier});
        }
        return nums;
    }
}