class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder chosen = new StringBuilder();
        chosen.append('(');
        int openCount = 1;
        int closedCount = 0;
        helperRec(n,chosen,ans,openCount,closedCount);
        return ans;
    }

    public void helperRec(int n, StringBuilder chosen, List<String> ans, int openCount, int closedCount){
        if(chosen.length()==2*n){
            ans.add(chosen.toString());
            return;
        } 
        //System.out.println(chosen.toString());
        if(openCount<n){
            chosen.append('(');
            openCount++;
            helperRec(n,chosen,ans,openCount,closedCount);
            chosen.deleteCharAt(chosen.length()-1);
            openCount--;
        }
        if(closedCount<openCount){
            chosen.append(')');
            closedCount++;
            helperRec(n,chosen,ans,openCount,closedCount);
            chosen.deleteCharAt(chosen.length()-1);
            closedCount--;
        }
    }
}