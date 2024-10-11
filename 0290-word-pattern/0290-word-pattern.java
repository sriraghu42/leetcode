class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> map1 = new HashMap<>();
        Map<String,Character> map2 = new HashMap<>();
        String[] words = s.split(" ");
        if(pattern.length()!=words.length) return false;
        int i=0;
        while(i<pattern.length()){
            char ch = pattern.charAt(i);
            String word = words[i];
            if(map1.containsKey(ch)){
                if(!map1.get(ch).equals(word)) return false;
            }
            else if(map2.containsKey(word)){
                if(!map2.get(word).equals(ch)) return false;
            }
            else{
                map1.put(ch,word);
                map2.put(word,ch);
            }
            i++;
        }
        return true;
    }
}