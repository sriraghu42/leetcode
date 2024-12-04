class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0;
        int j = 0;
        while(i<str1.length()){
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(j);
            if(char1 == char2) j++;
            else{
                if(char1 =='z' && char2 =='a') j++;
                else if((char) (char1+1) == char2) j++;
            }
            i++;
            if(j==str2.length()) return true;
        }
        return false;
    }
}