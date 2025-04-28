class Solution {
    public int characterReplacement(String s, int k) {
        int ans = 0;
        int i = 0;
        int j = 0;
        Map<Character,Integer> map = new HashMap<>();
        while(j<s.length()){
            char jCh = s.charAt(j);
            map.put(jCh,map.getOrDefault(jCh,0)+1);
            while(i<=j && !isValid(map,k,j-i+1)){
                char iCh = s.charAt(i);
                map.put(iCh,map.get(iCh)-1);
                if(map.get(iCh)==0) map.remove(iCh);
                i++;
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }

    public boolean isValid(Map<Character,Integer> map, int k, int size){
        int max = 0;
        for(int value : map.values()) max = Math.max(max,value);
        return size-max<=k;
    }
}

