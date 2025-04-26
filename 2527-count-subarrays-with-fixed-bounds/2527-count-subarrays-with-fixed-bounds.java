class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        Deque<Integer> minD = new ArrayDeque<>();
        Deque<Integer> maxD = new ArrayDeque<>();
        int i = 0;
        int j = 0;
        long ans = 0;
        int[] prefixCount = new int[nums.length];
        int counter = 0;
        for(int m = nums.length-1; m>=0; m--){
            prefixCount[m] = counter;
            if(nums[m]>=minK && nums[m]<=maxK) counter++;
            else counter = 0;
        }
        while(j<nums.length){
            if(nums[j]<minK || nums[j]>maxK){
                i=j+1;
                minD.clear();
                maxD.clear();
            }
            else{
                while(!minD.isEmpty() && nums[minD.peekLast()]>=nums[j]) minD.pollLast();
                minD.addLast(j);
                while(!maxD.isEmpty() && nums[maxD.peekLast()]<=nums[j]) maxD.pollLast();
                maxD.addLast(j);
                //System.out.println("j : "+j+", min : "+nums[minD.peekFirst()]+", max : "+nums[maxD])
                while(i<=j && nums[minD.peekFirst()]==minK && nums[maxD.peekFirst()]==maxK){
                    ans+=1+prefixCount[j];
                    i++;
                    while(!minD.isEmpty() && minD.peekFirst()<i) minD.pollFirst();
                    while(!maxD.isEmpty() && maxD.peekFirst()<i) maxD.pollFirst();
                }
            }
            j++;
        }
        return ans;
    }
}