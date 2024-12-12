class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int gift : gifts) pq.add(gift);
        while(k>0){
            int gift = (int) Math.floor(Math.sqrt(pq.poll()));
            pq.add(gift);
            k--;
        }
        long sum = 0;
        while(!pq.isEmpty()){
            sum+=(long) pq.poll();
        }
        return sum;
    }
}