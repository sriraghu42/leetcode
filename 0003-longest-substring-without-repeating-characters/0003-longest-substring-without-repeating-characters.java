class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int ans = 0;
        int len = s.length();
        while(right<len){
            char ch = s.charAt(right);
            while(left<=right && set.contains(ch)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            ans = Math.max(ans,right-left+1);
            right++;
        }
        return ans;
    }
}