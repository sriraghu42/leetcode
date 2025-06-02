class Solution {
    
    List<Integer> chosen = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        boolean[] visited = new boolean[len];
        helperRec(nums,len,visited);
        return ans;
    }

    public void helperRec(int[] nums, int len, boolean[] visited){
        if(chosen.size()==len){
            ans.add(new ArrayList<>(chosen));
            return;
        }
        for(int i=0; i<len; i++){
            if(!visited[i]){
                visited[i] = true;
                chosen.add(nums[i]);
                helperRec(nums,len,visited);
                chosen.remove(chosen.size()-1);
                visited[i] = false;
            }
        }
    }
}