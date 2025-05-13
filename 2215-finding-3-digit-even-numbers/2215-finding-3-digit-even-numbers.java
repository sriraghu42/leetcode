class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        int len = digits.length;
        int curr = 0;
        Arrays.sort(digits);
        boolean[] visited = new boolean[digits.length];
        search(digits,len,set,curr,visited);
        List<Integer> list = new ArrayList<>(set);
        list.sort(null);
        int[] ans = new int[list.size()];
        for(int i=0; i<ans.length; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }

    public void search(int[] digits, int len, Set<Integer> set, int curr, boolean[] visited){
        if(curr>99){
            if(curr%2==0) set.add(curr);
            return;
        }
        for(int i=0; i<len; i++){
            if(curr==0 && digits[i]==0) continue;
            if(!visited[i]){
                visited[i] = true;
                search(digits,len,set,curr*10+digits[i],visited);
                visited[i] = false;
            }
        }
    }
}