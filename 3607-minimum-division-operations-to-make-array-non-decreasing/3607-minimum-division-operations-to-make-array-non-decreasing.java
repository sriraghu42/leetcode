class Solution {
    public int minOperations(int[] nums) {
        int counter=0;
        for(int i=0; i<nums.length-1; i++){
            if(i>=0 && nums[i]<=nums[i+1]) continue;
            while(i>=0 && nums[i]>nums[i+1]){
                int div = getDivisor(nums[i]);
                //System.out.println(div);
                if(div==-1) return -1;
                counter++;
                nums[i] = nums[i]/div;
                i--;
            }
        }
        return counter;
    }

    public int getDivisor(int num){
        for(int i=2; i<= (int) Math.sqrt(num); i++){
            if(num % i == 0) return num/i;
        }
        return -1;
    }
}