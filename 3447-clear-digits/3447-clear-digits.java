class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)) stack.pop();
            else stack.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : stack) sb.append(ch);
        return sb.toString();
    }
}