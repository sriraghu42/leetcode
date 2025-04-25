class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String word : wordList) set.add(word);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        if(set.contains(beginWord)) set.remove(beginWord);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Pair p = q.poll();
                for(int j=0; j<beginWord.length(); j++){
                    char[] arr = p.word.toCharArray();
                    for(char ch = 'a'; ch<='z'; ch++){
                        if(ch!=p.word.charAt(j)){
                            arr[j]=ch;
                            String newStr = new String(arr);
                            if(set.contains(newStr)){
                                if(newStr.equals(endWord)) return p.level+1;
                                q.add(new Pair(newStr,p.level+1));
                                set.remove(newStr);
                            }
                        } 
                    }
                }
            }
        }
        return 0;
    }
}

class Pair{
    String word;
    int level;
    Pair(String word, int level){
        this.word = word;
        this.level = level;
    }
}