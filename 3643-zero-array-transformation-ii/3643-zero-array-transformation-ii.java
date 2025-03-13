class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int count = 0;
        for(int num : nums){
            if(num!=0) count++;
        }
        if(count == 0) return 0;
        int i = 0;
        int j = queries.length-1;
        while(i<=j){
            int k = (i+j)/2;
            int[] diffArray = new int[nums.length+1];
            for(int m=0; m<=Math.min(k,queries.length-1); m++){
                diffArray[queries[m][0]]+=queries[m][2];
                diffArray[queries[m][1]+1]-=queries[m][2];
            }
            int[] prefixSum = new int[nums.length];
            prefixSum[0] = diffArray[0];
            for(int n=1; n<nums.length; n++){
                prefixSum[n] = prefixSum[n-1]+diffArray[n];
            }
            //System.out.println("k : "+k);
            //for(int b=0; b<nums.length; b++) System.out.println(prefixSum[b]);
            int a = 0;
            while(a<nums.length){
                if(nums[a]> prefixSum[a]){
                    i=k+1;
                    break;
                }
                a++;
            }
            if(a==nums.length){
                //for(int b=0; b<nums.length; b++) System.out.println(prefixSum[b]);
                j=k-1;
            } 
            else i=k+1;
        }
        return i==queries.length?-1:i+1;
    }
}