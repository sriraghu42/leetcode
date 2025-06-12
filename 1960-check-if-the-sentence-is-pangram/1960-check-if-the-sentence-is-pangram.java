class Solution {
    public boolean checkIfPangram(String sentence) {
        int len = sentence.length();
        if(len<26) return false;
        Set<Character> set = new HashSet<>();
        for(char ch : sentence.toCharArray()) set.add(ch);
        return set.size()==26;
    }
}