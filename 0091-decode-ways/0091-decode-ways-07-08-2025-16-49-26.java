class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if(len==1 && s.charAt(0)!='0') return 1;
        int[] dp = new int[len];
        Arrays.fill(dp,-1);
        return backtrack(s,len,0,dp);
    }

    public int backtrack(String s, int len, int pos, int[] dp){
        if(pos==len){
            return 1;
        }
        if(dp[pos]!=-1) return dp[pos];
        if(s.charAt(pos)=='0') return 0;
        int counter = backtrack(s,len,pos+1,dp);
        if(pos!=len-1){
            int value = Integer.parseInt(s.substring(pos,pos+2));
            if(value<27) counter+=backtrack(s,len,pos+2,dp);
        }
        dp[pos] = counter;
        return dp[pos];
    }
}