class Solution {
    public String removeOccurrences(String s, String part) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int len = part.length();
        for(int i=0; i<s.length(); i++){
           //System.out.println("sb : "+sb.toString());
            char ch = s.charAt(i);
            stack.push(ch);
            if(sb.length()==len) sb.deleteCharAt(0);
            sb.append(ch);
            while(sb.toString().equals(part)){
                //System.out.println("Inside - sb : "+sb.toString());
                for(int j=0; j<len; j++) stack.pop();
                sb.setLength(0);
                int size = stack.size();
                int start = 0;
                if(size>=len) start = size-len;
                for(int k=start; k<size; k++) sb.append(stack.get(k));
            }
        }
        sb.setLength(0);
        for(char ch : stack) sb.append(ch);
        return sb.toString();
    }
}