class Solution {
    public int maxScore(String s) {
        int max = 0;
        int totalCount1 = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='1') totalCount1++;
        }
        int count0 = 0;
        int count1 = 0;
        for(int i=0; i<s.length()-1; i++){
            char ch = s.charAt(i);
            if(ch == '0') count0++;
            else if(ch == '1') count1++;
            max = Math.max(max, count0 + totalCount1 - count1);
        }
        return max;
    }
}