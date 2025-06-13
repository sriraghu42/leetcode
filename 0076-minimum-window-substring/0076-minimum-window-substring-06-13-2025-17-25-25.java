class Solution {
    public String minWindow(String s, String t) {
        int[] tArr = new int[58];
        int[] sArr = new int[58];
        for(char ch : t.toCharArray()){
            tArr[ch-'A']++;
        }
        int i = 0;
        int j = 0;
        int len = s.length();
        String ans = "";
        while(j<len){
            char jch = s.charAt(j);
            sArr[jch-'A']++;
            while(j-i+1>= t.length() && isValid(sArr,tArr)){
                if(ans.length()==0 || ans.length()>j-i+1) ans = s.substring(i,j+1);
                sArr[s.charAt(i)-'A']--;
                i++;
                while(i<=j && tArr[s.charAt(i)-'A']==0) i++;
            }
            j++;
        }
        return ans;
    }

    public boolean isValid(int[] sArr, int[] tArr){
        for(int i=0; i<58; i++){
            if(tArr[i]>0 && sArr[i]<tArr[i]) return false;
        }
        return true;
    }
}