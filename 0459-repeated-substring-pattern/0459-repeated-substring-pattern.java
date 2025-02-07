class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = 1;
        int length = s.length();
        while(len<=length/2){
            int j = 0;
            String sub = s.substring(0,len);
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<length/len; i++) sb.append(sub);
            if(sb.toString().equals(s)) return true;
            len++;
        }
        return false;
    }
}