class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String word : words) map.put(word,map.getOrDefault(word,0)+1);

        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>((a,b)->{
            if(a.getValue()- b.getValue()!=0) return a.getValue()- b.getValue();
            return b.getKey().compareTo(a.getKey());
        });

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            pq.offer(entry);
            if(pq.size()>k) pq.poll();
        }
        List<String> ans = new ArrayList<>();
        while(!pq.isEmpty()) ans.add(pq.poll().getKey());
        Collections.reverse(ans);
        return ans;
    }
}