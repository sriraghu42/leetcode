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
        int counter = 0;
        int value = 0;
        for(int i=pos; i<len; i++){
            char ch = s.charAt(i);
            value=value*10+ (ch-'0');
            if(value==0 || value>26){
                break;
            } 
            counter+=backtrack(s,len,i+1,dp);
        }
        dp[pos] = counter;
        return dp[pos];
    }
}