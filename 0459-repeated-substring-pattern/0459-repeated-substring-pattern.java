class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        if(len==1) return false;
        while(i<len){
            sb.append(s.charAt(i));
            if(sb.length()>len/2) break;
            StringBuilder newSb = new StringBuilder();
            String str = sb.toString();
            while(newSb.length()<len) newSb.append(str);
            if(s.equals(newSb.toString())) return true;
            i++;
        }
        return false;
    }
}