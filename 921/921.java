class Solution {
    public int minAddToMakeValid(String s) {
        int ans = 0;
        int counter = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                counter++;
            }
            else{
                if(counter>0) counter--;
                else ans++;
            }
        }
        ans+=counter;
        return ans;
    }
}