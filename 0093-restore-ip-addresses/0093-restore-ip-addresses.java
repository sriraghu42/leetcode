class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        search(s,len,sb,0,0);
        return ans;
    }

    public void search(String s, int len, StringBuilder sb, int index, int counter){
        if(counter==4 && index!=len) return;
        if(counter==4 && index==len){
            sb.setLength(sb.length()-1);
            ans.add(sb.toString());
            return;
        }
        for(int i=index; i<len; i++){
            int num = Integer.parseInt(s.substring(index,i+1));
            if(num>255 || String.valueOf(num).length()!=i-index+1) return;
            int currLen = sb.length();
            sb.append(num).append('.');
            search(s,len,sb,i+1,counter+1);
            sb.setLength(currLen);
        }
    }
}