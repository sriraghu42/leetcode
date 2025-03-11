class Solution {
    public int numberOfSubstrings(String s) {
        int len = s.length();
        int i = 0;
        int j = 0;
        int[] count = new int[3];
        int ans = 0;
        while(j<len){
            char ch = s.charAt(j);
            count[ch-'a']++;
            //if(count[0]>0 && count[1]>0 && count[2]>0) ans+=len-j-1;
            while(count[0]>0 && count[1]>0 && count[2]>0){
                ans+=len-j;
                count[s.charAt(i)-'a']--;
                i++;
            }
            j++;
        }
        return ans;
    }
}