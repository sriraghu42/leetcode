class Solution {
    public int takeCharacters(String s, int k) {
        int delLength = 0;
        int[] totCount = new int[3];
        for(int i=0; i<s.length(); i++){
            totCount[s.charAt(i)-'a']++;
        }
        if(totCount[0]<k || totCount[1]<k || totCount[2]<k) return -1;
        int i=0;
        int j=0;
        int[] count = new int[3];
        while(j<s.length()){
            char ch = s.charAt(j);
            count[ch-'a']++;
            while(totCount[0]-count[0]<k || totCount[1]-count[1]<k || totCount[2]-count[2]<k){
                char ch1 = s.charAt(i);
                count[ch1-'a']--;
                i++;
            }
            delLength = Math.max(delLength,j-i+1);
            j++;
        }
        return s.length()-delLength;
    }
}