class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>((a,b) -> Long.compare(a,b));
        for(int num : nums) pq.offer((long) num);
        int counter = 0;
        while(pq.peek()<k){
            System.out.println(pq.peek());
            counter++;
            long a = pq.poll();
            long b = pq.poll();
            long max=a>=b?a:b;
            long min=a>=b?b:a;
            pq.offer(min * 2 + max);
        }
        return counter;
    }
}