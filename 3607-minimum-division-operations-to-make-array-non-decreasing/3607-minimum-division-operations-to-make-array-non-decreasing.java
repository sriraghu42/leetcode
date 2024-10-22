class Solution {
    public int minOperations(int[] nums) {
        int count = 0;
        for(int i=nums.length-2; i>=0; i--){
            while(nums[i]>nums[i+1]){
                int div = getDivisor(nums[i]);
                if(div == -1) return -1;
                nums[i] = nums[i]/div;
                count++;
            }  
        }
        return count;
    }

    public int getDivisor(int num){
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i==0) return num/i;
        }
        return -1;
    }
}