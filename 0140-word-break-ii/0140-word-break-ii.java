class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>(wordDict);
        Map<Integer,List<String>> map = new HashMap<>();
        search(s,len,set,sb,0,map);
        return ans;
    }

    public void search(String s, int len, Set<String> set, StringBuilder sb, int index, Map<Integer,List<String>> map){
        if(index==len){
            sb.setLength(sb.length()-1);
            ans.add(sb.toString());
            return;
        }
        if(map.containsKey(index)){
            int currLen = sb.length();
            for(String str : map.get(index)){
                sb.append(str).append(" ");
                search(s,len,set,sb,index+str.length(),map);
                sb.setLength(currLen);
            }
            return;
        }
        for(int i=index; i<len; i++){
            String word = s.substring(index,i+1);
            if(set.contains(word)){
                int currLen = sb.length();
                sb.append(word).append(" ");
                List<String> list = new ArrayList<>();
                if(map.containsKey(index)){
                    list = map.get(index);
                }
                else map.put(index,list);
                list.add(word);
                search(s,len,set,sb,i+1,map);
                sb.setLength(currLen);
            }
        }
    }
}