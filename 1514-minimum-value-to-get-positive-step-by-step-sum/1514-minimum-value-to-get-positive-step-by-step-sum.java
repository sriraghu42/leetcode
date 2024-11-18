class Solution {
    public int minStartValue(int[] nums) {
        int minValue = nums[0];
        int sum = nums[0];
        for(int i=1; i<nums.length; i++){
            sum+=nums[i];
            minValue = Math.min(minValue,sum);
        }
        if(minValue<1) return 1-minValue;
        else return 1;
    }
}