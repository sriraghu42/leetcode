class Solution {
    List<List<String>> ans = new ArrayList<>();
    List<String> list = new ArrayList<>();
    public List<List<String>> partition(String s) {
        int len = s.length();
        helperRec(s,len,0);
        return ans;
    }
    public void helperRec(String s, int len, int index){
        if(index==len){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=index; i<len; i++){
            if(!isPalindrome(s,index,i)) continue;
            list.add(s.substring(index,i+1));
            helperRec(s,len,i+1);
            list.remove(list.size()-1);
        }
    }

    public boolean isPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}