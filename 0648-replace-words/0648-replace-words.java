class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        Set<String> prefixes = new HashSet<>(dictionary);
        StringBuilder ans = new StringBuilder();
        for(String word : words){
            StringBuilder sb = new StringBuilder();
            for(char ch : word.toCharArray()){
                sb.append(ch);
                if(prefixes.contains(sb.toString())){
                    word = sb.toString();
                    break;
                }
            }
            ans.append(word).append(" ");
        }
        ans.deleteCharAt(ans.length()-1);
        return ans.toString();
    }
}