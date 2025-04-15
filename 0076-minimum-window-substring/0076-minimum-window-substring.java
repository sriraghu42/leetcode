class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> sMap = new HashMap<>();
        Map<Character,Integer> tMap = new HashMap<>();
        for(char ch : t.toCharArray()) tMap.put(ch,tMap.getOrDefault(ch,0)+1);
        int i=0;
        int j=0;
        int len = s.length();
        String ans = "";
        while(j<len){
            char sch = s.charAt(j);
            sMap.put(sch,sMap.getOrDefault(sch,0)+1);
            while(checkIfValid(sMap,tMap)){
                if(ans.equals("") || j-i+1<ans.length()) ans = s.substring(i,j+1);
                char ich = s.charAt(i);
                sMap.put(ich,sMap.get(ich)-1);
                i++;
            } 
            j++;
        }
        return ans;
    }

    public boolean checkIfValid(Map<Character,Integer> sMap, Map<Character,Integer> tMap){
        for(char tMapKey:tMap.keySet()){
            if(!sMap.containsKey(tMapKey) || sMap.get(tMapKey)<tMap.get(tMapKey)) return false;
        }
        return true;
    }
}