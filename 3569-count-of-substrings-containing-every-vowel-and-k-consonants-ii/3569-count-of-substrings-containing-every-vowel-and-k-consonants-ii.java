class Solution {
    public long countOfSubstrings(String word, int k) {
        int consonantCount = 0;
        int[] letters = new int[26];
        long ans = 0;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int i = 0;
        int j = 0;
        int len = word.length();
        int[] nextConsonantIndex = new int[len];
        int index = len;
        for(int m=len-1; m>=0; m--){
            nextConsonantIndex[m] = index;
            if(!set.contains(word.charAt(m))) index = m;
        }
        while(j<len){
            char ch = word.charAt(j);
            if(set.contains(ch)) letters[ch-'a']++;
            else consonantCount++;
            while(letters[0]>0 && letters[4]>0 && letters[8]>0 && letters[14]>0 && letters[20]>0 && consonantCount==k){
                ans+=nextConsonantIndex[j]-j;
                char ich = word.charAt(i);
                if(set.contains(ich)) letters[ich-'a']--;
                else consonantCount--;
                i++;
            } 
            while(consonantCount>k){
                char ich = word.charAt(i);
                if(set.contains(ich)) letters[ich-'a']--;
                else consonantCount--;
                i++;
            }
            j++;
        }
        return ans;
    }
}