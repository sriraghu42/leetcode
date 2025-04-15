class Solution {
    public int shortestSubarray(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int ans = Integer.MAX_VALUE;
        long[] prefixSum = new long[nums.length+1];
        long sum = 0;
        prefixSum[0] = 0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            prefixSum[i+1] = sum;
        } 
        dq.add(0);
        for(int i=1; i<prefixSum.length; i++){
            while(!dq.isEmpty() && prefixSum[dq.peekFirst()]<=prefixSum[i]-k) ans = Math.min(ans,i-dq.pollFirst());
            while(!dq.isEmpty() && prefixSum[dq.peekLast()]>=prefixSum[i]) dq.pollLast();
            dq.addLast(i);
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}