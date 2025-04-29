class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek()[0]==ch-'a') stack.push(new int[] {ch-'a',stack.pop()[1]+1});
            else stack.push(new int[] {ch-'a',1});
            if(stack.peek()[1]==k) stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        for(int[] arr : stack) {
            char ch = (char) (arr[0]+97);
            int freq = arr[1];
            while(freq>0){
                sb.append(ch);
                freq--;
            }
        }
        return sb.toString();
    }
}