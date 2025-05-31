class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int[] arr = new int[26];
        for(char ch : s1.toCharArray()) arr[ch-'a']++;
        for(char ch : s2.toCharArray()) arr[ch-'a']--;
        for(int i=0; i<26; i++){
            if(arr[i]!=0) return false;
        }
        int counter = 0;
        int i = 0;
        int j = 0;
        int len = s1.length();
        while(i<len){
            if(s1.charAt(i)!=s2.charAt(j)) counter++;
            i++;
            j++;
        }
        return counter<=2;
    }
}