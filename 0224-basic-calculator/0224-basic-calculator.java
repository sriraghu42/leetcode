class Solution {
    public int calculate(String s) {
        int sum = 0;
        int sign = 1;
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch==' ') continue;
            if(Character.isDigit(ch)){
                num = num*10+ch-'0';
            }
            else if(ch=='+'){
                sum+=num*sign;
                num=0;
                sign=1;
            }
            else if(ch=='-'){
                sum+=num*sign;
                num=0;
                sign=-1;
            }
            else if(ch=='('){
                stack.push(sum);
                stack.push(sign);
                sum = 0;
                sign=1;
            }
            else if(ch==')'){
                sum+=num*sign;
                num = 0;
                sum*=stack.pop();
                sum+=stack.pop();  
            }
        }
        sum+=num*sign;
        return sum;
    }
}