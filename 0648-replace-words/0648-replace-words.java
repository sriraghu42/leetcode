class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        dictionary.sort(null);
        StringBuilder sb = new StringBuilder();
        for(String word : words){
            for(String prefix : dictionary){
                if(word.startsWith(prefix)){
                    word = prefix;
                    break;
                }
            }
            sb.append(word).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}