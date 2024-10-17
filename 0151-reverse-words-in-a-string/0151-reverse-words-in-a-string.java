class Solution {
    public String reverseWords(String s) {
        String trimmedString = s.trim();
        String[] arr = trimmedString.split(" ");
        Stack<String> stack = new Stack<>();
        for(String str : arr){
            if(!str.equals("")) stack.push(str);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}