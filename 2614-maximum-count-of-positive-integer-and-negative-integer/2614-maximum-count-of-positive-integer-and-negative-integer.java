class Solution {
    public int maximumCount(int[] nums) {
        int posCount = 0;
        int negCount = 0;
        int i = 0;
        int j = nums.length-1;
        while(i<=j){
            int k = (i+j)/2;
            if(nums[k]<=0) i=k+1;
            else{
                if(k==0 || nums[k-1]<=0){
                    posCount = nums.length - k;
                    break;
                } 
                else j=k-1;
            }
        }
        i = 0;
        j = nums.length-1;
        while(i<=j){
            int k = (i+j)/2;
            if(nums[k]>=0) j=k-1;
            else{
                if(k==nums.length -1|| nums[k+1]>=0){
                    negCount = k+1;
                    break;
                } 
                else i=k+1;
            }
        }
        return Math.max(posCount,negCount);
    }
}