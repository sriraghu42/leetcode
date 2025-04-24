class Solution {
    public String reorganizeString(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            pq.add(new int[] {(int) entry.getKey(),entry.getValue()});
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int[] first = pq.poll();
            if(sb.length()>0 && sb.charAt(sb.length()-1)==first[0]){
                if(pq.isEmpty()) return "";
                int[] second = pq.poll();
                sb.append((char) second[0]);
                second[1]--;
                if(second[1]>0) pq.add(second);
            }
            sb.append((char) first[0]);
            first[1]--;
            if(first[1]>0) pq.add(first);
        }
        return sb.toString();
    }
}