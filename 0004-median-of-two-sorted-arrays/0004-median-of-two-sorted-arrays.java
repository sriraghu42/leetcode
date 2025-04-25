class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArr = new int[nums1.length+nums2.length];
        int i = 0;
        int j = 0;
        int counter = 0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<=nums2[j]){
                mergedArr[counter] = nums1[i];
                i++;
            }
            else {
                mergedArr[counter] = nums2[j];
                j++;
            }
            counter++;
        }
        while(i<nums1.length){
            mergedArr[counter] = nums1[i];
            i++;
            counter++;
        }
        while(j<nums2.length){
            mergedArr[counter] = nums2[j];
            j++;
            counter++;
        }
        if(counter%2==0) return (mergedArr[counter/2]+mergedArr[(counter/2) -1])/2.0;
        else return (double) mergedArr[(counter-1)/2];
    }
}