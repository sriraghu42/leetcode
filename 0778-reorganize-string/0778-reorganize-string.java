class Solution {
    public String reorganizeString(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            pq.add(new int[] {entry.getKey()-'a',entry.getValue()});
        }
        int[] first = new int[2];
        int[] second = new int[2];
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            char ch = (char) (curr[0]+97);
            if(sb.length()>0 && ch==sb.charAt(sb.length()-1)) return "";
            sb.append(ch);
            curr[1]--;
            first = second;
            second = curr;
            if(first[1]!=0) pq.add(first);
        }
        System.out.println("String : "+sb.toString());
        if(first[1]!=0){
            char ch = (char) (first[0]+97);
            if(ch==sb.charAt(sb.length()-1)) return "";
            sb.append(ch);
        }
        if(second[1]!=0){
            char ch = (char) (second[0]+97);
            if(ch==sb.charAt(sb.length()-1)) return "";
            sb.append(ch);
        }
        return sb.toString();
    }
}