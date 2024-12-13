class Solution {
    public long findScore(int[] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            int val = a[1]-b[1];
            if(val!=0) return val;
            else return a[0]-b[0];
        });
        for(int i=0; i<nums.length; i++) pq.add(new int[] {i,nums[i]});
        long score = 0;
        boolean[] marked = new boolean[nums.length];
        while(!pq.isEmpty()){
            int[] scr = pq.poll();
            if(marked[scr[0]]) continue;
            score+= scr[1];
            int index = scr[0];
            marked[index] = true;
            if(index>0) marked[index-1] = true;
            if(index<marked.length-1) marked[index+1] = true;
        }
        return score;
    }
}