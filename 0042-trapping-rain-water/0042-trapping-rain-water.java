class Solution {
    public int trap(int[] height) {
        int i = 0;
        int j = 1;
        int ans = 0;
        while(j<height.length){
            while(j<height.length && height[j]<height[i]) j++;
            if(j==height.length) break;
            for(int m=i+1; m<j; m++) ans+=height[i]-height[m];
            i=j;
            j++;
        }
        int peak = i;
        i = height.length-1;
        j = height.length-2;
        while(j>peak-1){
            while(j>peak-1 && height[j]<height[i]) j--;
            if(j==peak-1) break;
            for(int m=i-1; m>j; m--) ans+=height[i]-height[m];
            i=j;
            j--;
        }
        return ans;
    }
}