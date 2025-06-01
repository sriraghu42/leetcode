class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<String> set = new HashSet<>();
        Set<Character> visited = new HashSet<>();
        int len = s.length();
        int[] lastPos = new int[26];
        Arrays.fill(lastPos,-1);
        for(int i=len-1; i>=0; i--){
            char ich = s.charAt(i);
            if(lastPos[ich-'a']!=-1) continue;
            lastPos[ich-'a']=i;
        }
        for(int i=0; i<len; i++) {
            char ich = s.charAt(i);
            if(visited.contains(ich)) continue;
            visited.add(ich);
            int j = lastPos[ich-'a'];
            for(int c=i+1; c<j; c++) set.add(""+ich+s.charAt(c)+ich);
        }
        return set.size();
    }
}
