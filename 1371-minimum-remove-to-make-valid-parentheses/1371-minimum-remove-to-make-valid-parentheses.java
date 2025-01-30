class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb  = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int j = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch!='(' && ch!=')') sb.append(ch);
            else if(ch=='('){
                j = Math.max(j,i+1);
                boolean foundClose = false;
                while(j<s.length()){
                    if(s.charAt(j)==')'){
                        foundClose = true;
                        break;
                    }
                    j++;
                }
                if(foundClose){
                    sb.append(ch);
                    stack.push(ch);
                    j++;
                }
            }
            else{
                if(!stack.isEmpty() && stack.pop()=='(') sb.append(ch);
            }
        }
        return sb.toString();
    }
}