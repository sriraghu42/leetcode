class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> chosen = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        helperRec(nums,chosen,res,0);
        return res;
    }

    public void helperRec(int[] nums, List<Integer> chosen, List<List<Integer>> res, int index){
        res.add(new ArrayList<>(chosen));
        if(index==nums.length) return;
        for(int i=index; i<nums.length; i++){
            //System.out.println(nums[index]);
            chosen.add(nums[i]);
            helperRec(nums,chosen,res,i+1);
            chosen.remove(chosen.size()-1);
        }
    }
}