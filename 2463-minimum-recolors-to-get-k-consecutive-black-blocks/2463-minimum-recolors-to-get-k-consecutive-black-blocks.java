class Solution {
    public int minimumRecolors(String blocks, int k) {
        int blackCount = 0;
        int i = 0;
        int j = 0;
        int ans = Integer.MAX_VALUE;
        while(j<blocks.length()){
            char ch = blocks.charAt(j);
            if(ch=='B') blackCount++;
            if(j-i+1==k){
                ans = Math.min(ans,k-blackCount);
                if(blocks.charAt(i)=='B') blackCount--;
                i++;
            } 
            j++;
        }
        return ans;
    }
}


//sliding window os size k by maintaining b-block count