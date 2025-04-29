class Solution {
    public String minRemoveToMakeValid(String s) {
        int openCount = 0;
        int closeCount = 0;
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch=='(') openCount++;
            else if(ch==')' && openCount>closeCount) closeCount++;
        }
        int reqCount = Math.min(openCount,closeCount);
        //System.out.println(reqCount);
        openCount = 0;
        closeCount = 0;
        for(char ch : s.toCharArray()){
            if(ch=='(' && openCount>=reqCount) continue;
            if(ch==')' && closeCount==openCount) continue;
            if(ch=='(') openCount++;
            else if(ch==')') closeCount++;
            sb.append(ch);
        }
        return sb.toString();
    }
}