class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        Set<String> set = new HashSet<>(wordDict);
        Set<Integer> failedSet = new HashSet<>();
        return search(s,len,set,0,failedSet);
    }

    public boolean search(String s, int len, Set<String> set, int index, Set<Integer> failedSet){
        if(failedSet.contains(index)) return false;
        if(index==len) return true;
        for(int i=index; i<len; i++){
            if(set.contains(s.substring(index,i+1))){
                if(search(s,len,set,i+1,failedSet)) return true;
            }
        }
        failedSet.add(index);
        return false;
    }
}