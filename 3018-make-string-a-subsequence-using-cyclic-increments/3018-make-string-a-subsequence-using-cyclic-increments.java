class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0;
        int j = 0;
        int len1 = str1.length();
        int len2 = str2.length();
        while(i<len1 && j<len2){
            char ich = str1.charAt(i);
            char jch = str2.charAt(j);
            if(jch-ich==0 || jch-ich==1 || jch-ich==-25){
                i++;
                j++;
            }
            else i++;
        }
        if(j==len2) return true;
        else if(i==len1) return false;
        return false;
    }
}