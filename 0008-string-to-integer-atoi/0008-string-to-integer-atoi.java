class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length()==0) return 0;
        boolean sign = false;
        int start = 0;
        if(s.charAt(0)=='-') sign = true;
        if(s.charAt(0)=='-' || s.charAt(0)=='+') start = 1;
        long num = 0;
        for(int i=start; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num*10 + (ch-'0');
                if(num>Integer.MAX_VALUE){
                    if(sign) return Integer.MIN_VALUE;
                    else return Integer.MAX_VALUE;
                }
            } 
            else break;
        }
        if(sign) num = 0-num;
        if(num>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(num<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) num;
    }
}