class Solution {
    public String[] findRelativeRanks(int[] score) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : score){
            pq.offer(num);
        }
        String[] ref = new String[] {"Gold Medal", "Silver Medal", "Bronze Medal"};
        Map<Integer, String> map = new HashMap<>();
        int counter=0;
        while(!pq.isEmpty()){
            if(counter>2){
                map.put(pq.poll(),String.valueOf(counter+1));
            }
            else{
                map.put(pq.poll(),ref[counter]);
            }
            counter++;
        }
        String[] ans = new String[score.length];
        for(int i=0; i<score.length; i++){
            ans[i] = map.get(score[i]);
        }
        return ans;
    }
}