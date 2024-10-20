class Solution {
    public int numberOfSubstrings(String s, int k) {
        int[] countArray = new int[26];
        int counter = 0;
        int i = 0;
        int j = 0;
        while(j<s.length()){
            int index = s.charAt(j) - 'a';
            countArray[index]++;
            if(countArray[index]>=k){
                counter+=s.length()-j;
                countArray[s.charAt(i)-'a']--;
                i++;
                while(countArray[index]>=k){
                    counter+=s.length()-j;
                    countArray[s.charAt(i)-'a']--;
                    i++;
                }
            }
            j++;
        }
        return counter;
    }
}