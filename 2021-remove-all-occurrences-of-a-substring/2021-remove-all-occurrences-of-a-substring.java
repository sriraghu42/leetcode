class Solution {
    public String removeOccurrences(String s, String part) {
        int len = part.length();
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            sb.append(ch);
            if(sb.length()>=len && sb.substring(sb.length()-len).equals(part)) sb.setLength(sb.length()-len);
        }
        return sb.toString();
    }
}