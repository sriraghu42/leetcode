class Solution {
    public String reorganizeString(String s) {
        int[] arr = new int[26];
        for(char ch : s.toCharArray()) arr[ch-'a']++;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            int compValue = b[1]-a[1];
            if(compValue!=0) return compValue;
            else return a[0]-b[0];
        }
            );
        for(int i=0; i<26; i++){
            if(arr[i]>0) pq.add(new int[] {i,arr[i]});
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int[] first = pq.poll();
            char ch = (char) (first[0]+97);
            if(sb.length()>0 && sb.charAt(sb.length()-1)==ch)  return "";
            sb.append(ch);
            first[1]--;
            if(!pq.isEmpty()){
                int[] second = pq.poll();
                char ch2 = (char) (second[0]+97);
                if(sb.length()>0 && sb.charAt(sb.length()-1)==ch2)  return "";
                sb.append(ch2);
                second[1]--;
                if(second[1]>0) pq.add(second);
            }
            if(first[1]>0) pq.add(first);
        }
        return sb.toString();
    }
}