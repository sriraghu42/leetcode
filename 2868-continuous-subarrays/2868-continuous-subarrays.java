class Solution {
    public long continuousSubarrays(int[] nums) {
        Deque<Integer> maxDq = new ArrayDeque<>();
        Deque<Integer> minDq = new ArrayDeque<>();
        int i = 0;
        int j = 0;
        long ans = 0;
        int len = nums.length;
        while(j<len){
            while(!maxDq.isEmpty() && nums[maxDq.peekLast()]<=nums[j]) maxDq.pollLast();
            while(!minDq.isEmpty() && nums[minDq.peekLast()]>=nums[j]) minDq.pollLast();
            maxDq.addLast(j);
            minDq.addLast(j);
            while(nums[maxDq.peekFirst()]-nums[minDq.peekFirst()]>2){
                i++;
                while(!minDq.isEmpty() && minDq.peekFirst()<i) minDq.pollFirst();
                while(!maxDq.isEmpty() && maxDq.peekFirst()<i) maxDq.pollFirst();
            }
            ans+=j-i+1;
            j++;
        }
        return ans;
    }
}