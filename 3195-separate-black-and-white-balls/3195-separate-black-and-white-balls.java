class Solution {
    public long minimumSteps(String s) {
        int len = s.length();
        int lastBlack = len;
        long ans = 0;
        for(int i=len-1; i>=0; i--){
            if(s.charAt(i)=='1'){
                ans+=lastBlack-i-1;
                lastBlack--;
            }
        }
        return ans;
    }
}