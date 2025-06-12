class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        int len = arr.length;
        int i=0;
        int j=0;
        int counter = 0;
        while(j<len){
            sum+=arr[j];
            if(j-i+1==k){
                if((sum/k)>=threshold) counter++;
                sum-=arr[i];
                i++;
            }
            j++;
        }
        return counter;
    }
}