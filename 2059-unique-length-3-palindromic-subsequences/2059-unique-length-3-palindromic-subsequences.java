class Solution {
    public int countPalindromicSubsequence(String s) {
        int counter = 0;
        Set<Character> set1 = new HashSet<>();
        for(int i=0; i<s.length()-2; i++){
            if(!set1.contains(s.charAt(i))){
                for(int j=s.length()-1; j>i+1; j--){
                    if(s.charAt(j)==s.charAt(i)){
                        set1.add(s.charAt(i));
                        Set<Character> set2 = new HashSet<>();
                        for(int k=i+1;k<j;k++){
                            if(!set2.contains(s.charAt(k))){
                                set2.add(s.charAt(k));
                                counter++;
                            }
                        }
                        break;
                    } 
                }
            }
        }
        return counter;
    }
}