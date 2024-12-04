class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while(i<s.length()){
            char ch = s.charAt(i);
            if(j<spaces.length && i==spaces[j]){
                j++;
                sb.append(" ");
            } 
            sb.append(ch);
            i++;
        }
        return sb.toString();
    }
}