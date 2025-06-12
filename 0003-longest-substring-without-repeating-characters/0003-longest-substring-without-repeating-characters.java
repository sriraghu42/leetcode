class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int len = s.length();
        int ans = 0;
        while(j<len){
            char ch = s.charAt(j);
            while(i<j && set.contains(ch)){
                set.remove(s.charAt(i));
                i++;
            }
            set.add(ch);
            ans = Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}