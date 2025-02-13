class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int num : nums) pq.offer((long) num);
        int counter = 0;
        while(pq.peek()<k){
            counter++;
            long min = pq.poll();
            long max = pq.poll();
            pq.offer(min * 2 + max);
        }
        return counter;
    }
}