class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        int start = 0;
        int length = Integer.MAX_VALUE;
        int[] arr = new int[128];
        int count = t.length();
        for(char ch : t.toCharArray()){
            arr[ch]++;
        }
        int i = 0;
        int j = 0;
        while(j<s.length()){
            char ch = s.charAt(j);
            arr[ch]--;
            if(arr[ch]>=0) count--;
            while(count==0){
                if(length>j-i+1){
                    start = i;
                    length = j-i+1;
                } 
                arr[s.charAt(i)]++;
                if(arr[s.charAt(i)] > 0) count++;
                i++;
            }
            j++;
        }
        return length!=Integer.MAX_VALUE?s.substring(start,start+length):"";
    }
}