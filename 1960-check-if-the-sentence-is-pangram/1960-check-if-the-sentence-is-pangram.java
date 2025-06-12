class Solution {
    public boolean checkIfPangram(String sentence) {
        int len = sentence.length();
        if(len<26) return false;
        int[] arr = new int[26];
        for(char ch : sentence.toCharArray()) arr[ch-'a']++;
        for(int i=0; i<26; i++){
            if(arr[i]==0) return false;
        }
        return true;
    }
}