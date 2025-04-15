class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> dqMax = new ArrayDeque<>();
        Deque<Integer> dqMin = new ArrayDeque<>();
        int maxLen = 0;
        int i = 0;
        int j = 0;
        int ans = 0;
        while(j<nums.length){
            while(i<=j && !dqMin.isEmpty() && !dqMax.isEmpty() && (Math.abs(nums[j]-nums[dqMax.peekFirst()])>limit || Math.abs(nums[j]-nums[dqMin.peekFirst()])>limit)){
                if(dqMin.peekFirst()==i) dqMin.pollFirst();
                if(dqMax.peekFirst()==i) dqMax.pollFirst();
                i++;
            }
            while(!dqMax.isEmpty() && nums[dqMax.peekLast()]<=nums[j]) dqMax.pollLast();
            dqMax.addLast(j);
            while(!dqMin.isEmpty() && nums[dqMin.peekLast()]>=nums[j]) dqMin.pollLast();
            dqMin.addLast(j);
            ans = Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}