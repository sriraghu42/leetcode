class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> chosen = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        helperRec(nums,chosen,res,0);
        return res;
    }

    public void helperRec(int[] nums, List<Integer> chosen, List<List<Integer>> res, int index){
        if(index==nums.length){
            res.add(new ArrayList<>(chosen));
            return;
        }
        helperRec(nums,chosen,res,index+1);
        chosen.add(nums[index]);
        helperRec(nums,chosen,res,index+1);
        chosen.remove(chosen.size()-1);
    }
}