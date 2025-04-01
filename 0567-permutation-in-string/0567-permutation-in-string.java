class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] a = new int[26];
        int[] b  =new int[26];
        for(char ch : s1.toCharArray()){
            a[ch-'a']++;
        }
        int i = 0;
        int j = 0;
        int len1 = s1.length();
        int len2 = s2.length();
        while(j<len2){
            b[s2.charAt(j)-'a']++;
            if(j-i+1==len1){
                if(Arrays.equals(a,b)) return true;
                b[s2.charAt(i)-'a']--;
                i++;
            }  
            j++;
        }
        return false;
    }
}