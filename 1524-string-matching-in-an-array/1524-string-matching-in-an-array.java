class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        for(String word1:words){
            for(String word2:words){
                if(word1.equals(word2)) continue;
                if(word2.contains(word1)) {
                    ans.add(word1);
                    break;
                }
            }
        }
        return ans;
    }
}