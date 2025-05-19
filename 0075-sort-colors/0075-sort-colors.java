class Solution {
    public void sortColors(int[] nums) {
        int[] counter = new int[3];
        for(int num : nums) counter[num]++;
        int i=0;
        while(i<counter[0]){
            nums[i] = 0;
            i++;
        } 
        while(i<counter[0]+counter[1]){
            nums[i] = 1;
            i++;
        } 
        while(i<counter[0]+counter[1]+counter[2]){
            nums[i] = 2;
            i++;
        } 
        return ;
    }
}