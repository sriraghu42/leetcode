class Solution {
    public int trap(int[] height) {
        int i = 0;
        int len = height.length;
        int ans = 0;
        int end = -1;
        while(i<len){
            int j = i+1;
            while(j<len && height[j]<height[i]) j++;
            if(j==len){
                end = i;
                break;
            }
            int compValue = height[i];
            while(i<j){
                ans+=compValue - height[i];
                i++;
            }
            i=j;
        }
        if(end!=-1){
            i=len-1;
            while(i>=end){
                int j = i-1;
                while(j>=end && height[j]<height[i]) j--;
                if(j<end) break;
                int compValue = height[i];
                while(i>j){
                    ans+=compValue - height[i];
                    i--;
                }
                i=j;
            }
        }
        return ans;
    }
}