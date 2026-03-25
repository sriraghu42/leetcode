class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        Arrays.sort(candidates);
        List<Integer> chosen = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates,target,len,chosen,ans,0);
        return ans;
    }

    public void backtrack(int[] candidates, int target, int len, List<Integer> chosen, List<List<Integer>> ans, int pos){
        if(target<0) return;
        if(target==0){
            ans.add(new ArrayList<>(chosen));
        }
        for(int i=pos;i<len;i++){
            chosen.add(candidates[i]);
            backtrack(candidates,target-candidates[i],len,chosen,ans,i);
            chosen.remove(chosen.size()-1);
        }
    }
}