class Solution {
    public String[] findRelativeRanks(int[] score) {
        List<Integer> list = new ArrayList<>();
        for(int num : score) list.add(num);
        Collections.sort(list,Collections.reverseOrder());
    
        String[] ref = new String[] {"Gold Medal", "Silver Medal", "Bronze Medal"};
        Map<Integer, String> map = new HashMap<>();
        for(int i=0; i<Math.min(score.length,3); i++){
            map.put(list.get(i),ref[i]);
        }
        for(int i=3;i<score.length; i++){
            map.put(list.get(i),String.valueOf(i+1));
        }
        String[] ans = new String[score.length];
        for(int i=0; i<score.length; i++){
            ans[i] = map.get(score[i]);
        }
        return ans;
    }
}