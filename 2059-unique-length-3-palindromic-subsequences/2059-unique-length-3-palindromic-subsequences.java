class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<String> set = new HashSet<>();
        Set<Character> visited = new HashSet<>();
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<len; i++) {
            char ich = s.charAt(i);
            if(visited.contains(ich)) continue;
            visited.add(ich);
            int j = len-1;
            while(j>i){
                char jch = s.charAt(j);
                if(ich==jch){
                    for(int c=i+1; c<j; c++) {
                        sb.append(ich).append(s.charAt(c)).append(jch);
                        set.add(sb.toString());
                        sb.setLength(0);
                    }
                    break;
                }
                j--;
            }
        }
        return set.size();
    }
}