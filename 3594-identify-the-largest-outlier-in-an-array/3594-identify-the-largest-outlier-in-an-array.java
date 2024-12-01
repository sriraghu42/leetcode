class Solution {
    public int getLargestOutlier(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.sort(nums);
        int totSum = 0;
        for(int i=0; i<nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            totSum+=nums[i];
        }
        for(int i=nums.length-1; i>=0; i--){
            if(i<nums.length-1 && nums[i]==nums[i+1]) continue;
            map.put(nums[i],map.get(nums[i])-1);
            int remSum = (totSum - nums[i]);
            if(remSum % 2 !=0) ;
            else if(map.containsKey(remSum/2) && map.get(remSum/2)>0){
                System.out.println(remSum);
                System.out.println(totSum);
                return nums[i];
            } 
            map.put(nums[i],map.get(nums[i])+1);
        }
        return 0;
    }
}