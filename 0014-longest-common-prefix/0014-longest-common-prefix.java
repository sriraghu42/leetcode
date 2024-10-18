class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String firstWord = strs[0];
        String lastWord = strs[strs.length-1];
        for(int i=0; i<firstWord.length(); i++){
            if(firstWord.charAt(i)!=lastWord.charAt(i)) return firstWord.substring(0,i);
        }
        return firstWord;
    }
}