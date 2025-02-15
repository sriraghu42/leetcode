class Solution {
    public int myAtoi(String s) {
        int ans = 0;
        s = s.trim();
        int len = s.length();
        if(len==0) return 0;
        boolean neg = false;
        int i = 0;
        char ch = s.charAt(i);
        if(ch=='-'){
            i++;
            neg = true;
        } 
        else if(ch =='+') i++;
        while(i<len){
            ch = s.charAt(i);
            if(!Character.isDigit(ch)) break;
            int digit = ch - '0';
            if(ans>(Integer.MAX_VALUE-digit)/10){
                return neg?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            ans = ans*10+ digit;
            i++;
        }
        return neg?0-ans:ans;
    }
}