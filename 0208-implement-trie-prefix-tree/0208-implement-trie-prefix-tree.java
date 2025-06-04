class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        int len = word.length();
        TrieNode node = root;
        for(int i=0; i<len; i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)) node.put(ch,new TrieNode());
            node = node.get(ch);
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        int len = word.length();
        TrieNode node = root;
        for(int i=0; i<len; i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)) return false;
            node = node.get(ch);
        }
        if(node.isEnd()) return true;
        return false;
    }
    
    public boolean startsWith(String prefix) {
        int len = prefix.length();
        TrieNode node = root;
        for(int i=0; i<len; i++){
            char ch = prefix.charAt(i);
            if(!node.containsKey(ch)) return false;
            node = node.get(ch);
        }
        return true;
    }
}

class TrieNode{
    TrieNode[] links;
    boolean isEnd;
    TrieNode(){
        links = new TrieNode[26];
    }

    public TrieNode get(char ch){
        return links[ch-'a'];
    }

    public void put(char ch, TrieNode node){
        links[ch-'a'] = node;
    }

    public void setEnd(){
        isEnd = true;
    }

    public boolean isEnd(){
        return isEnd;
    }

    public boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */