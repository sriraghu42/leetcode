class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>(wordDict);
        search(s,len,set,sb,0);
        return ans;
    }

    public void search(String s, int len, Set<String> set, StringBuilder sb, int index){
        if(index==len){
            sb.setLength(sb.length()-1);
            ans.add(sb.toString());
            return;
        }
        for(int i=index; i<len; i++){
            String word = s.substring(index,i+1);
            if(set.contains(word)){
                int currLen = sb.length();
                sb.append(word).append(" ");
                search(s,len,set,sb,i+1);
                sb.setLength(currLen);
            }
        }
    }
}