class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int i=0; i<26; i++){
            if(freq[i]>0) pq.add(new int[] {i,freq[i]});
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int[] highest = pq.poll();
            char key = (char) (highest[0]+'a');
            int count = highest[1];
            int limit = Math.min(count,repeatLimit);
            for(int i=0; i<limit; i++){
                sb.append(key);
            }
            count-=limit;
            if(count>0){
                if(pq.isEmpty()) break;
                int[] secondHighest = pq.poll();
                sb.append((char) (secondHighest[0]+'a'));
                if(secondHighest[1]>1) pq.add(new int[] {secondHighest[0],secondHighest[1]-1});
                pq.add(new int[] {highest[0],count});
            }
        }
        return sb.toString();
    }
}