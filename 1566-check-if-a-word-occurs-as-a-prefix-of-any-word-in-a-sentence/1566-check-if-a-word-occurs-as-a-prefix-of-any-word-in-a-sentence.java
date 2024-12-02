class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        sentence = sentence.trim();
        String[] words = sentence.split(" ");
        for(int i=0; i<words.length; i++){
            String word = words[i];
            if(checkPrefix(word,searchWord)) return i+1;
        }
        return -1;
    }

    public boolean checkPrefix(String word, String searchWord){
        if(word.length()<searchWord.length()) return false;
        for(int i=0; i<searchWord.length(); i++){
            if(word.charAt(i)!=searchWord.charAt(i)) return false;
        }
        return true;
    }
}