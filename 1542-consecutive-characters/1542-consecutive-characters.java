class Solution {
    public int maxPower(String s) {
        int ans = 1;
        int counter = 1;
        for(int j=1; j<s.length(); j++){
            if(s.charAt(j)==s.charAt(j-1)) counter++;
            else counter = 1;
            ans = Math.max(counter,ans);
        }
        return ans;
    }
}