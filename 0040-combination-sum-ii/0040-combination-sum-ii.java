class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> chosen = new ArrayList<>();
        int len = candidates.length;
        Arrays.sort(candidates);
        helperRec(candidates,len,target,chosen,0,0);
        return ans;
    }

    public void helperRec(int[] candidates, int len, int target, List<Integer> chosen, int sum, int index){
        if(sum==target){
            ans.add(new ArrayList<>(chosen));
            return;
        }
        //[1,1,2,5,6,7,10]
        for(int i=index; i<len; i++){
            if(i>0 && i!=index && candidates[i]==candidates[i-1]) continue;
            if(sum+candidates[i]>target) break;
            chosen.add(candidates[i]);
            helperRec(candidates,len,target,chosen,sum+candidates[i],i+1);
            chosen.remove(chosen.size()-1);
        }
    }
}