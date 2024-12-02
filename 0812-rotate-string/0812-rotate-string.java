class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        char first = goal.charAt(0);
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==first && check(s,i,goal)) return true; 
        }
        return false;
    }

    public boolean check(String s, int i, String goal){
        int slen = s.length();
        for(int j=0; j<goal.length(); j++){
            if(s.charAt(i)!=goal.charAt(j)) return false;
            if(i==slen-1) i=0;
            else i++;
        }
        return true;
    }
}