class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums) set.add(num);
        int distinct = set.size();
        Map<Integer,Integer> map = new HashMap<>();
        int i = 0; 
        int j = 0;
        int ans = 0;
        while(j<nums.length){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            if(map.size()==distinct){
                int k = j+1;
                int sum = 0;
                while(k<nums.length && map.containsKey(nums[k])){
                    sum++;
                    k++;
                }
                while(i<=j && map.size()==distinct){
                    ans+=sum+1;
                    map.put(nums[i],map.get(nums[i])-1);
                    if(map.get(nums[i])==0) map.remove(nums[i]);
                    i++;
                } 
            }
            j++;
        }
        return ans;
    }
}