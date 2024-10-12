class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        for(int i=0; i<tokens.length; i++){
            String token = tokens[i];
            if(!set.contains(token)){
                stack.push(Integer.parseInt(token));
            }
            else{
                int a = stack.pop();
                int b = stack.pop();
                int c = 0;
                if(token.equals("+")) c = b+a;
                if(token.equals("-")) c = b-a;
                if(token.equals("*")) c = b*a;
                if(token.equals("/")) c = b/a;
                stack.push(c);
            }
        }
        return stack.pop();
    }
}