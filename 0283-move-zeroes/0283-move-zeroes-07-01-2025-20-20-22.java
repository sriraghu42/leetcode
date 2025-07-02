class Solution {
    public void moveZeroes(int[] nums) {
        int indexPos = 0;
        int currPos = 0;
        int len = nums.length;
        while(currPos<len){
            if(nums[currPos]!=0){
                nums[indexPos]  = nums[currPos];
                indexPos++;
            }
            currPos++;
        }
        while(indexPos<len){
            nums[indexPos]=0;
            indexPos++;
        }
    }
}