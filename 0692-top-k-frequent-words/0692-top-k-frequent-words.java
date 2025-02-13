class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            if(a.count-b.count!=0) return a.count-b.count;
            return b.word.compareTo(a.word);
        });
        Map<String,Integer> map = new HashMap<>();
        for(String word : words) map.put(word,map.getOrDefault(word,0)+1);
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            pq.offer(new Pair(entry.getKey(),entry.getValue()));
            if(pq.size()>k) pq.poll();
        }
        List<String> ans = new ArrayList<>();
        while(!pq.isEmpty()) ans.add(pq.poll().word);
        Collections.reverse(ans);
        return ans;
    }
}

class Pair{
    String word;
    int count;
    Pair(String word,int count){
        this.word = word;
        this.count = count;
    }
}