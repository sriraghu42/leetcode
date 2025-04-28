class Solution {
    public int characterReplacement(String s, int k) {
        int ans = 0;
        int i = 0;
        int j = 0;
        int[] arr = new int[26];
        int len = s.length();
        while(j<len){
            char jCh = s.charAt(j);
            arr[jCh-'A']++;
            while(i<=j && !isValid(arr,k,j-i+1)){
                char iCh = s.charAt(i);
                arr[iCh-'A']--;
                i++;
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }

    public boolean isValid(int[] arr, int k, int size){
        int max = 0;
        for(int value : arr) max = Math.max(max,value);
        return size-max<=k;
    }
}

