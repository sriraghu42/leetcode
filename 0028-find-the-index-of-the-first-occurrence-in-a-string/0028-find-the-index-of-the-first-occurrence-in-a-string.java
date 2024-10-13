class Solution {
    public int strStr(String haystack, String needle) {
        int windowSize = needle.length();
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while(j<haystack.length()){
            char ch = haystack.charAt(j);
            sb.append(ch);
            if(j-i+1==windowSize){
                if(sb.toString().equals(needle)) return i;
                else{
                    sb.deleteCharAt(0);
                    i++;
                }
            }
            j++;
        }
        return -1;
    }
}