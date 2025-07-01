class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int i = 0;
        int j = 0;
        int ans = 0;
        Map<Character,Integer> map = new HashMap<>();
        while(j<len){
            char jch = s.charAt(j);
            map.put(jch,map.getOrDefault(jch,0)+1);
            while(map.get(jch)>1){
                char ich = s.charAt(i);
                map.put(ich,map.get(ich)-1);
                i++;
            }
            ans = Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}