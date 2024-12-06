class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int counter = 0;
        Set<Integer> set = new HashSet<>();
        for(int ban : banned){
            set.add(ban);
        }
        int sum = 0;
        for(int i = 1; i<=n; i++){
            if(!set.contains(i)){
                sum+=i;
                if(sum<=maxSum) counter++;
                else break;
            }
        }
        return counter;
    }
}