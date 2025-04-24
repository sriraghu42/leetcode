class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        for(String word : wordList) wordSet.add(word);
        if(!wordSet.contains(endWord)) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        while(!q.isEmpty()){
            int size = q.size();
            Pair p = q.poll();
            for(int w=0; w<beginWord.length(); w++){
                StringBuilder sb = new StringBuilder(p.word);
                char chW = p.word.charAt(w);
                for(char ch = 'a'; ch<='z'; ch++){
                    if(ch!=chW){
                        sb.setCharAt(w,ch);
                        String newString = sb.toString();
                        if(newString.equals(endWord)) return p.num+1;
                        if(wordSet.contains(newString)){
                            wordSet.remove(newString);
                            q.add(new Pair(newString,p.num+1));
                        } 
                    }
                }
            }
        }
        return 0;
    }
}

class Pair{
    int num;
    String word;
    Pair(String word, int num){
        this.word = word;
        this.num = num;
    }
}