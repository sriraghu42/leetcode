class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int len = s.length();
        Set<Integer> visited = new HashSet<>();
        return search(s,set,0,len,visited);
    }

    public boolean search(String s, Set<String> set,int index, int len, Set<Integer> visited){
        if(visited.contains(index)) return false;
        if(index == len) return true;
        StringBuilder temp = new StringBuilder();
        for(int i=index; i<len; i++){
            temp.append(s.charAt(i));
            if(set.contains(temp.toString())){
                if(search(s,set,i+1,len,visited)) return true;
                else visited.add(i+1);
            }
        }
        return false;
    }
}