class Solution {
    public String minWindow(String s, String t) {
        int[] sArr = new int[58];
        for(char ch : t.toCharArray()){
            sArr[ch-'A']++;
        }
        int i = 0;
        int j = 0;
        int len = s.length();
        String ans = "";
        while(j<len){
            char jch = s.charAt(j);
            sArr[jch-'A']--;
            while(i<=j && isValid(sArr)){
                if(ans.length()==0 || ans.length()>j-i+1) ans = s.substring(i,j+1);
                sArr[s.charAt(i)-'A']++;
                i++;
            }
            j++;
        }
        return ans;
    }

    public boolean isValid(int[] sArr){
        for(int i=0; i<58; i++){
            if(sArr[i]>0) return false;
        }
        return true;
    }
}