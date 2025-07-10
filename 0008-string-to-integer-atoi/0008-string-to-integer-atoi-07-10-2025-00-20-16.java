class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int len = s.length();
        long ans = 0;
        boolean pos = true;
        while(i<len && s.charAt(i)==' ') i++;
        if(i<len && s.charAt(i)=='-'){
            pos=false;
            i++;
        } 
        else if(i<len && s.charAt(i)=='+'){
            pos=true;
            i++;
        } 
        for(int j=i; j<len; j++){
            char ch = s.charAt(j);
            //if(ch=='-' && j==i) pos = false;
            //else if(ch=='+' && j==i) pos = true;
            if(Character.isDigit(ch)){
                ans = ans*10 + (ch-'0');
                if((pos && ans>=Integer.MAX_VALUE) || (!pos && ans>Integer.MAX_VALUE)){
                    ans = (pos?Integer.MAX_VALUE:Integer.MAX_VALUE+1);
                    break;
                }
            }
            else break;
        }
        return (int) (pos?ans:0-ans);
    }
}