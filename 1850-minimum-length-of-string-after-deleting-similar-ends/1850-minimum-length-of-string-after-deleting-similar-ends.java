class Solution {
    public int minimumLength(String s) {
        int i = 0;
        int j = s.length()-1;
        while(i<=j){
            if(i==j) return 1;
            if(s.charAt(i)!=s.charAt(j)) return j-i+1;
            while(i<s.length()-1 && s.charAt(i)==s.charAt(i+1)) i++;
            while(j>0 && s.charAt(j)==s.charAt(j-1)) j--;
            i++;
            j--;
        }
        return 0;
    }
}