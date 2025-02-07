class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = 1;
        int length = s.length();
        while(len<=length/2){
            int j = 0;
            String sub = s.substring(0,len);
            while(j<=length-len){
                if(!s.substring(j,j+len).equals(sub)) break;
                j+=len;
                if(j>=length) return true;
            }
            len++;
        }
        return false;
    }
}