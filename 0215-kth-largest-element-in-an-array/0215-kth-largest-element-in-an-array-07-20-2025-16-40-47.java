class Solution {
    public int findKthLargest(int[] nums, int k) {
        int small = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE;
        for(int num : nums){
            small = Math.min(small,num);
            large = Math.max(large,num);
        }
        int[] arr = new int[large-small+1];
        for(int num : nums){
            arr[num-small]+=1;
        }
        for(int i=arr.length-1; i>=0; i--){
            k-=arr[i];
            if(k<=0) return i+small;
        }
        return -1;
    }
}
