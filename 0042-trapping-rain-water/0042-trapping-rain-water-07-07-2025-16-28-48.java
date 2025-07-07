class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int len = height.length;
        int i=0;
        int j=1;
        while(j<len){
            while(j<len && height[j]<height[i]) j++;
            if(j==len) break;
            for(int k=i+1; k<j; k++){
                ans+=(height[i]-height[k]);
            }
            i=j;
            j++;
        }
        int end = i;
        i=len-1;
        j=len-2;
        while(j>=end){
            while(j>=0 && height[j]<height[i]) j--;
            if(j<0) break;
            for(int k=i-1; k>j; k--){
                ans+=(height[i]-height[k]);
            }
            i=j;
            j--;
        }

        return ans;
    }
}