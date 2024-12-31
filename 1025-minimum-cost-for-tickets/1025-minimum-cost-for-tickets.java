class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> set = new HashSet<>();
        for(int day : days) set.add(day);
        int[] dp = new int[days[days.length-1]+1];
        Arrays.fill(dp,-1);
        return solve(days,costs,dp,set,1);
    }

    public int solve(int[] days, int[] costs, int[] dp, Set<Integer> set, int currDay){
        if(currDay>days[days.length-1]) return 0;
        if(!set.contains(currDay)) return solve(days,costs,dp,set,currDay+1);
        if(dp[currDay]!=-1) return dp[currDay];
        int oneDay = costs[0]+solve(days,costs,dp,set,currDay+1);
        int sevenDay = costs[1]+solve(days,costs,dp,set,currDay+7);
        int thirtyDay = costs[2]+solve(days,costs,dp,set,currDay+30);
        dp[currDay] = Math.min(oneDay,Math.min(sevenDay,thirtyDay));
        return dp[currDay];
    }
}