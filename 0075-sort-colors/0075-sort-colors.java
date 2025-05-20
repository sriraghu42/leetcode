class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int i = 0;
        int j = len-1;
        int k = 0;
        while(i<j && k<=j){
            if(nums[k]==0){
                int temp = nums[i];
                nums[i] = 0;
                nums[k]= temp;
                i++;
                k++;
            }
            else if(nums[k]==2){
                int temp = nums[j];
                nums[j] = 2;
                nums[k] = temp;
                j--;
            }
            else{
                k++;
            }
        }
        return ;
    }
}