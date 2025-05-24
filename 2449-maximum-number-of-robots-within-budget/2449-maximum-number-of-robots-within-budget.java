class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        Deque<Integer> dq = new ArrayDeque<>();
        int i = 0;
        int j = 0;
        int len = chargeTimes.length;
        long sum = 0;
        int ans = 0;
        while(j<len){
            sum+=runningCosts[j];
            while(!dq.isEmpty() && chargeTimes[j]>=chargeTimes[dq.peekLast()]) dq.pollLast();
            dq.addLast(j);
            while(i<=j && chargeTimes[dq.peekFirst()] + (j-i+1) * sum>budget){
                sum-=runningCosts[i];
                i++;
                while(!dq.isEmpty() && dq.peekFirst()<i) dq.pollFirst();
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}

/*
3 -> 3 + 1*2 = 5
3,6 -> 6 + 2*3 = 12
3,6,1 -> 6+3*6 = 24
3,6,1,3 -> 6+4*10 = 46 out of budget
6,1,3 ->  6 +3 * 8 = 30 out of budget -> 46-4*2
*/