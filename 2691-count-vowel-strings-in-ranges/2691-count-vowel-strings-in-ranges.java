class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int[] count = new int[words.length];
        int counter = 0;
        for(int i=0; i<words.length; i++){
            String word = words[i];
            if(set.contains(word.charAt(0)) && set.contains(word.charAt(word.length()-1))){
                counter++;
            }
            count[i] = counter;
        }
        int[] ans = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            int[] query = queries[i];
            if(query[0]==0) ans[i] = count[query[1]]-0;
            else ans[i] = count[query[1]]-count[query[0]-1];
        }
        return ans;
    }
}