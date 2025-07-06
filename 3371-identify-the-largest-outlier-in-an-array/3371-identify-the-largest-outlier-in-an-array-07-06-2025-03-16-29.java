class Solution {
    public int getLargestOutlier(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        for(int num:nums){
            sum+=num;
            map.put(num,map.getOrDefault(num,0)+1);
        }
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int num = nums[i];
            sum-=num;
            map.put(num,map.get(num)-1);
            if(sum%2==0 && map.containsKey(sum/2) && map.get(sum/2)>0) ans=Math.max(ans,num);
            sum+=num;
            map.put(num,map.get(num)+1);
        }
        return ans;
    }
}