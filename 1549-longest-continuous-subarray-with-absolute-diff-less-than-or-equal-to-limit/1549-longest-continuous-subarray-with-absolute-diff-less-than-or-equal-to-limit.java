class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> mindq = new ArrayDeque<>();
        Deque<Integer> maxdq = new ArrayDeque<>();
        int i = 0;
        int j = 0;
        int ans = 1;
        while(j<nums.length){
            while(!mindq.isEmpty() && nums[mindq.peekLast()]>=nums[j]) mindq.pollLast();
            while(!maxdq.isEmpty() && nums[maxdq.peekLast()]<=nums[j]) maxdq.pollLast();
            maxdq.addLast(j);
            mindq.addLast(j);
            while(Math.abs(nums[mindq.peekFirst()] - nums[maxdq.peekFirst()])>limit){
                i++;
                while(!mindq.isEmpty() && mindq.peekFirst()<i) mindq.pollFirst();
                while(!maxdq.isEmpty() && maxdq.peekFirst()<i) maxdq.pollFirst();
            }
            ans = Math.max(ans,j-i+1); 
            j++;
        }
        return ans;
    }
}