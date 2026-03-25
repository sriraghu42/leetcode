class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int len = s.length();
        int ans = 0;
        for(int right = 0; right<len; right++){
            char curr = s.charAt(right);
            while(set.contains(curr)){
                set.remove(s.charAt(left));
                left++;
            } 
            set.add(curr);
            ans = Math.max(ans,right-left+1);
        }
        return ans;
    }
}