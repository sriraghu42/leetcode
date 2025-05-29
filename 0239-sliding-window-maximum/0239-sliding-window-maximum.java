class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int i = 0;
        int j = 0;
        int len = nums.length;
        int[] ans = new int[len-k+1];
        while(j<len){
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[j]) dq.pollLast();
            dq.addLast(j);
            if(j-i+1==k){
                while(!dq.isEmpty() && dq.peekFirst()<i) dq.pollFirst();
                ans[j-k+1] = nums[dq.peekFirst()];
                i++;
            }
            j++;
        }
        return ans;
    }
}
