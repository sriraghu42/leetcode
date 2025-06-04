class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if(len2<len1) return false;
        int[] a = new int[26];
        for(char ch : s1.toCharArray()){
            a[ch-'a']++;
        }
        int i = 0;
        int j = 0;
        while(j<len2){
            a[s2.charAt(j)-'a']--;
            if(j-i+1==len1){
                if(isValid(a)) return true;
                a[s2.charAt(i)-'a']++;
                i++;
            }  
            j++;
        }
        return false;
    }

    public boolean isValid(int[] arr){
        for(int num : arr){
            if(num!=0) return false;
        }
        return true;
    }
}