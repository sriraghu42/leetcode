class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int i = 1;
        int j = 0;
        for(int num : nums){
            j = Math.max(j,num);
        }
        while(i<j){
            int k = i + (j-i)/2;
            int counter = 0;
            for(int num : nums){
                counter+= (num+k-1)/k-1;
            }
            if(counter<=maxOperations) j=k;
            else i=k+1;
        }
        return i;
    }
}