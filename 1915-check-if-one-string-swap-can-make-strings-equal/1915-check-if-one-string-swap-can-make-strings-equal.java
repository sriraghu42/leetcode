class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int firstIndex = -1;
        int secondIndex = -1;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                if(firstIndex == -1) firstIndex = i;
                else if(secondIndex == -1 ) secondIndex = i;
                else return false;
            }
        }
        if(firstIndex==-1 && secondIndex==-1) return true;
        if(firstIndex==-1 || secondIndex==-1) return false;
        if(s1.charAt(firstIndex)==s2.charAt(secondIndex) && s1.charAt(secondIndex)==s2.charAt(firstIndex)) return true;
        return false;
    }
}