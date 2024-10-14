class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums){
            pq.offer(num);
        }
        int ans = 0;
        while(k>0){
            ans = pq.poll();
            k--;
        }
        return ans;
    }
}