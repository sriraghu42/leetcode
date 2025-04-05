class Solution {
    public boolean isValid(Map<Character,Integer> sMap, Map<Character,Integer> tMap){
        for(char ch : tMap.keySet()){
            if(!sMap.containsKey(ch) || sMap.get(ch)<tMap.get(ch)) return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        String ans = "";
        if(t.length()>s.length()) return ans;
        Map<Character,Integer> tMap = new HashMap<>();
        for(char ch : t.toCharArray()) tMap.put(ch,tMap.getOrDefault(ch,0)+1);
        int i = 0;
        int j = 0;
        Map<Character,Integer> sMap = new HashMap<>();
        while(j<s.length()){
            char ch = s.charAt(j);
            sMap.put(ch,sMap.getOrDefault(ch,0)+1);
            while(j-i+1>=t.length() && isValid(sMap,tMap)){
                if(ans=="" || ans.length()>j-i+1) ans = s.substring(i,j+1);
                char iCh = s.charAt(i);
                sMap.put(iCh,sMap.get(iCh)-1);
                i++;
            }
            j++;
        }
        return ans;
    }
}