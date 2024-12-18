class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            int num = prices[i];
            ans[i] = prices[i];
            for(int j=i+1; j<n; j++){
                if(prices[j]<=num){
                    ans[i] = num-prices[j];
                    break;
                }
            }
        }
        return ans;
    }
}