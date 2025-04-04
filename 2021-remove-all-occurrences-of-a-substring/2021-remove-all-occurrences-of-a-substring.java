class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder();
        int targetLength = part.length();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            sb.append(ch);
            while(sb.length()>=targetLength && 
            sb.substring(sb.length()-targetLength,sb.length()).equals(part)){
                sb.setLength(sb.length()-targetLength);
            }
        }
        return sb.toString();
    }
}