class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        int j=1;
        int counter = 1;
        while(j<s.length()){
            if(s.charAt(j)==s.charAt(j-1)) counter++;
            else counter = 1;
            if(counter<3) sb.append(s.charAt(j));
            j++;
        }
        return sb.toString();
    }
}