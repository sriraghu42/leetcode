class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> sMap = new HashMap<>();
        Map<Character,Integer> tMap = new HashMap<>();
        for(char ch : t.toCharArray()) tMap.put(ch,tMap.getOrDefault(ch,0)+1);
        int i = 0;
        int j = 0;
        int len = s.length();
        String ans = "";
        int[] pre = new int[len];
        int nearest = len;
        for(int k=len-1; k>=0; k--){
            pre[k] = nearest;
            if(tMap.containsKey(s.charAt(k))) nearest = k;
        }
        if(!tMap.containsKey(s.charAt(i))) i=pre[i];
        while(j<len){
            char jch = s.charAt(j);
            if(tMap.containsKey(jch)) sMap.put(jch,sMap.getOrDefault(jch,0)+1);
            while(i <= j && sMap.size()==tMap.size() && isValid(sMap,tMap)){
                if(ans.length()==0 || j-i+1<ans.length()){
                    ans = s.substring(i,j+1); 
                } 
                char ich = s.charAt(i);
                sMap.put(ich,sMap.get(ich)-1);
                if(sMap.get(ich)==0) sMap.remove(ich);
                i=pre[i];
            }
            j++;
        }
        return ans;
    }

    public boolean isValid(Map<Character,Integer> sMap,Map<Character,Integer> tMap){
        for(char key : tMap.keySet()){
            if(!sMap.containsKey(key) || sMap.get(key)<tMap.get(key)) return false;
        }
        return true;
    }
}