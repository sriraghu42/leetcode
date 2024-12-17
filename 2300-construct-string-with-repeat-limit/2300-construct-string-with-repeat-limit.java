class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        TreeMap<Character,Integer> treeMap = new TreeMap<>();
        for(char ch: s.toCharArray()){
            treeMap.put(ch,treeMap.getOrDefault(ch,0)+1);
        }
        StringBuilder sb = new StringBuilder();
        while(!treeMap.isEmpty()){
            Map.Entry<Character,Integer> entry = treeMap.lastEntry();
            char key = entry.getKey();
            int val = entry.getValue();
            if(val<=repeatLimit){
                for(int i=0; i<val; i++) sb.append(key);
                treeMap.remove(key);
            }
            else{
                for(int i=0; i<repeatLimit; i++) sb.append(key);
                treeMap.put(key,val-repeatLimit);
                if(treeMap.size()==1) break;
                char lowKey = treeMap.lowerKey(key);
                sb.append(lowKey);
                treeMap.put(lowKey,treeMap.get(lowKey)-1);
                if(treeMap.get(lowKey)==0) treeMap.remove(lowKey);
            }
        }
        return sb.toString();
    }
}