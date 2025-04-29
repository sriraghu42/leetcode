class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> set = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='(') stack.push(i);
            else if(ch==')'){
                if(!stack.isEmpty()) stack.pop();
                else set.add(i);
            }
        }
        while(!stack.isEmpty()) set.add(stack.pop());
        StringBuilder sb  = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(!set.contains(i)) sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}