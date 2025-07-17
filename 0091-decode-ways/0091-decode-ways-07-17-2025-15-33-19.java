class Solution {
    int len;
    int[] dp;
    public int numDecodings(String s) {
        len = s.length();
        dp = new int[len];
        Arrays.fill(dp,-1);
        return helperRec(s,0);
    }

    public int helperRec(String s, int pos){
        if(pos==len) return 1;
        if(dp[pos]!=-1) return dp[pos];
        int count = 0;
        if(s.charAt(pos)=='0') return count;
        count+=helperRec(s,pos+1);
        if(pos<len-1 && Integer.parseInt(s.substring(pos,pos+2))<=26){
            count+=helperRec(s,pos+2);
        }
        return dp[pos] = count;
    }
}