class Solution {
    public boolean checkValidString(String s) {
        Set<Integer> set = new HashSet<>();
        Stack<Pair> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='(') stack.push(new Pair('(',i));
            else if(ch==')'){
                if(!stack.isEmpty() && stack.peek().ch=='(') stack.pop();
                else stack.push(new Pair(')',i));
            }
            else set.add(i);
        } 
        while(!stack.isEmpty()){
            Pair p = stack.pop();
            char ch = p.ch;
            int index = p.index;
            if(ch=='('){
                int check = index+1;
                while(check<s.length() && !set.contains(check)){
                    check++;
                }
                if(check==s.length()) return false;
                else set.remove(check);
            }
            else if(ch==')'){
                int check = index-1;
                while(check>=0 && !set.contains(check)){
                    check--;
                }
                if(check==-1) return false;
                else set.remove(check);
            }
        }
        return true;
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