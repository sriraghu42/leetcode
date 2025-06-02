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
        if(index==len){
            System.out.println(chosen);
            chosen.sort(null);
            ans.add(new ArrayList<>(chosen));
            return;
        }
        helperRec(nums,len,index+1);
        chosen.add(nums[index]);
        helperRec(nums,len,index+1);
        chosen.remove(chosen.size()-1);
    }
}