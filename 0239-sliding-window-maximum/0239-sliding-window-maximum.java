class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] ans = new int[len-k+1];
        int i = 0;
        int j = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        while(j<len){
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[j]) dq.pollLast();
            dq.addLast(j);
            if(j-i+1==k){
                ans[j-k+1] = nums[dq.peekFirst()];
                i++;
                while(!dq.isEmpty() && dq.peekFirst()<i) dq.pollFirst();
            }
            j++;
        }
        return ans;
    }
}