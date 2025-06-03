class Solution {
    List<Integer> chosen = new ArrayList<>();
    Set<List<Integer>> ans = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        helperRec(nums,len,0);
        return new ArrayList<>(ans);
    }

    public void helperRec(int[] nums, int len, int index){
        ans.add(new ArrayList<>(chosen));
        if(index==len) return;
        for(int i=index; i<nums.length; i++){
            if(i!=index && nums[i]==nums[i-1]) continue;
            chosen.add(nums[i]);
            helperRec(nums,len,i+1);
            chosen.remove(chosen.size()-1);
        }
    }
}