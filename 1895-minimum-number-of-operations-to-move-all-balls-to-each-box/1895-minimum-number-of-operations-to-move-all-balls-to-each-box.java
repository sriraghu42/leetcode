class Solution {
    public int[] minOperations(String boxes) {
        int[] ans = new int[boxes.length()];
        int count = 0;
        for(int i=0; i<boxes.length(); i++){
            count = 0;
            for(int j=0; j<boxes.length(); j++){
                if(boxes.charAt(j)=='1') count+= Math.abs(j-i);
            }
            ans[i] = count;
        }
        return ans;
    }
}