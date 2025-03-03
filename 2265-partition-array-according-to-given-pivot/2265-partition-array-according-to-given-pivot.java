class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
        int counter = 0;
        for(int num : nums){
            if(num<pivot){
                ans[counter] = num;
                counter++;
            }
        }
        for(int num : nums){
            if(num==pivot){
                ans[counter] = num;
                counter++;
            }
        }
        for(int num : nums){
            if(num>pivot){
                ans[counter] = num;
                counter++;
            }
        }
        return ans;
    }
}