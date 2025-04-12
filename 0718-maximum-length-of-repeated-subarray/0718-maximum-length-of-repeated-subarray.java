class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int ans = -1;
        for(int i = 0; i<nums1.length; i++){
            if(ans>=nums1.length-i-1) break;
            for(int j=0; j<nums2.length; j++){
                if(nums1[i]==nums2[j]){
                    int counter = 0;
                    int a = i;
                    int b = j;
                    while(a<nums1.length && b<nums2.length && nums1[a]==nums2[b]){
                        counter++;
                        a++;
                        b++;
                    }
                    ans = Math.max(ans,counter);
                }
            }
        }
        return ans==-1?0:ans;
    }
}