class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[nums.length-k+1];
        for(int i=0; i<nums.length; i++){
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]) dq.pollLast();
            if(!dq.isEmpty() && dq.peekFirst()<=i-k) dq.pollFirst();
            dq.addLast(i);
            if(i>=k-1) ans[i-k+1] = nums[dq.peekFirst()];
        }
        return ans;
    }
}