class Solution {
    public void moveZeroes(int[] nums) {
        int i=0;
        int len = nums.length;
        while(i<len && nums[i]!=0) i++;
        if(i==len || i==len-1) return ;
        int j = i+1;
        while(j<len){
            if(nums[j]!=0){
                nums[i] = nums[j];
                nums[j]=0;
                i++;
            }
            j++;
        }
    }
}
