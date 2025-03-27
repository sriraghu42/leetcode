class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens){
            if(token.equals("+") || token.equals("*") || token.equals("-") || token.equals("/")){
                int secondNum = stack.pop();
                int firstNum = stack.pop();
                switch(token){
                    case "+":
                        stack.push(firstNum+secondNum);
                        break;
                    case "-":
                        stack.push(firstNum-secondNum);
                        break;
                    case "*":
                        stack.push(firstNum*secondNum);
                        break;
                    case "/":
                        stack.push(firstNum/secondNum);
                        break;
                }
            }
           else stack.push(Integer.parseInt(token)); 
        }
        return stack.pop();
    }
}