class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long num1Sum = 0;
        long num2Sum = 0;
        boolean num1Increase = false;
        boolean num2Increase = false;
        for(int num : nums1){
            if(num==0){
                num1Increase = true;
                num1Sum++;
            }
            else num1Sum+=num;
        }
        for(int num : nums2){
            if(num==0){
                num2Increase = true;
                num2Sum++;
            }
            else num2Sum+=num;
        }
        if(num1Sum==num2Sum) return num1Sum;
        if(num1Sum>num2Sum && num2Increase) return num1Sum;
        if(num2Sum>num1Sum && num1Increase) return num2Sum;
        return -1;
    }
}

/*
nums1   nums2
nums1>nums2 && nums2increase
nums2>num1 && num1increase
nums1==nums2
*/