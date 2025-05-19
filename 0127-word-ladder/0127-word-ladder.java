class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        if(set.contains(beginWord)) set.remove(beginWord);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int counter = 1;
        while(!q.isEmpty()){
            counter++;
            int len = q.size();
            for(int i=0; i<len; i++){
                String word = q.poll();
                for(int j=0; j<beginWord.length(); j++){
                    StringBuilder sb = new StringBuilder(word);
                    for(int k=0; k<26; k++){
                        sb.setCharAt(j,(char) (k+97));
                        String curr = sb.toString();
                        //System.out.println(curr);
                        if(curr.equals(endWord)) return counter;
                        if(set.contains(curr)){
                            q.add(curr);
                            set.remove(curr);
                        } 
                    }
                }
            }
        }
        return 0;
    }
}