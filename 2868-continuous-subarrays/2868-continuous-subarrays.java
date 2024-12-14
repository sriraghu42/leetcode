class Solution {
    public long continuousSubarrays(int[] nums) {
        long counter = 0;
        int i = 0;
        int j = 0;
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        while(j<nums.length){
            treeMap.put(nums[j],treeMap.getOrDefault(nums[j],0)+1);
            while(treeMap.lastEntry().getKey() - treeMap.firstEntry().getKey()>2){
                treeMap.put(nums[i],treeMap.get(nums[i])-1);
                if(treeMap.get(nums[i])==0) treeMap.remove(nums[i]);
                i++;
            }
            counter+=j-i+1;
            j++;
        }
        return counter;
    }
}