class Solution {
    public int numberOfSubstrings(String s, int k) {
        int[] arr = new int[26];
        int i = 0;
        int j = 0;
        int count = 0;
        while(j<s.length()){
            int index = s.charAt(j) - 'a';
            arr[index]++;
            while(arr[index]>=k){
                count+=s.length()-j;
                arr[s.charAt(i)-'a']--;
                i++;
            }
            j++;
        }
        return count;
    }
}