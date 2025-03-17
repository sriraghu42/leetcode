class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        int[] prefixSum = new int[words.length+1];
        prefixSum[0]=0;
        for(int i=0; i<words.length; i++){
            String word = words[i];
            if(vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length()-1))){
                prefixSum[i+1] = prefixSum[i]+1;
            }
            else prefixSum[i+1] = prefixSum[i];
        }
        int[] ans = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            int[] query = queries[i];
            ans[i] = prefixSum[query[1]+1] - prefixSum[query[0]];
        }
        return ans;
    }
}