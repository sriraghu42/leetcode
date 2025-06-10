class Solution {
    public int maxDifference(String s) {
        int maxOdd = 0;
        int minEven = Integer.MAX_VALUE;
        int[] arr = new int[26];
        for(char ch : s.toCharArray()) arr[ch-'a']++;
        for(int i=0; i<26; i++){
            if(arr[i]==0) continue;
            if(arr[i]%2==0) minEven = Math.min(minEven,arr[i]);
            else maxOdd = Math.max(maxOdd,arr[i]);
        }
        return maxOdd - minEven;
    }
}