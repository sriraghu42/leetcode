class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb = new StringBuilder();
        backtrack(s,sb,0,0);
        return ans;
    }

    public void backtrack(String s, StringBuilder sb, int index,int counter){
        if(counter==4 && index==s.length()){
            sb.deleteCharAt(sb.length()-1);
            ans.add(sb.toString());
            return;
        } 
        else if(counter==4 || index==s.length()) return;
        for(int i=index; i<s.length(); i++){
            if(i>index && s.charAt(index)=='0') return;
            int sum=Integer.parseInt(s.substring(index,i+1));
            if(sum>255) return;
            int lenBefore = sb.length();
            sb.append(sum).append('.');
            backtrack(s,sb,i+1,counter+1);
            //System.out.println("sb:"+sb);
            //System.out.println("i:"+i);
            //System.out.println("index"+index);
            sb.setLength(lenBefore);
        }
    }
}