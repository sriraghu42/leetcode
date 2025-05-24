class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Pair> stack = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='(') stack.push(new Pair('(',i));
            else if(ch==')'){
                if(stack.isEmpty() || stack.peek().ch==')') stack.push(new Pair(')',i));
                else stack.pop();
            }
        }
        Set<Integer> set = new HashSet<>();
        for(Pair p : stack) set.add(p.index);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(!set.contains(i)) sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}

class Pair{
    char ch;
    int index;
    Pair(char ch, int index){
        this.ch = ch;
        this.index = index;
    }
}