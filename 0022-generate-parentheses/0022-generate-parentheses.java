class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        int openCount = 0;
        int closeCount = 0;
        StringBuilder sb = new StringBuilder();
        generate(n,openCount,closeCount,sb,ans);
        return ans;
    }

    public void generate(int n, int openCount, int closeCount, StringBuilder sb, List<String> ans){
        if(sb.length()==2*n){
            ans.add(sb.toString());
            return;
        }
        if(openCount!=n){
            sb.append('(');
            openCount++;
            generate(n,openCount,closeCount,sb,ans);
            sb.deleteCharAt(sb.length()-1);
            openCount--;
        }
    
        if(closeCount<openCount){
            sb.append(')');
            closeCount++;
            generate(n,openCount,closeCount,sb,ans);
            sb.deleteCharAt(sb.length()-1);
            closeCount--;
        }
    }
}