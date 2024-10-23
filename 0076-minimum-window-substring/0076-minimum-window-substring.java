class Solution {
    public String minWindow(String s, String t) {
        StringBuilder sb = new StringBuilder();
        String result = "";
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        for(char ch : t.toCharArray()){
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }
        for(char ch : map1.keySet()){
            map2.put(ch,0);
        }
        int i = 0;
        while(i<s.length() && !map2.containsKey(s.charAt(i))){
            i++;
        }
        int j = i;
        while(j<s.length()){
            char ch = s.charAt(j);
            sb.append(ch);
            if(i<s.length() && result.length()!=0 && sb.length()>result.length()){
                if(map2.containsKey(s.charAt(i))) map2.put(s.charAt(i),map2.get(s.charAt(i))-1);
                i++;
                sb.deleteCharAt(0);
            }
            if(map2.containsKey(ch)){
                map2.put(ch,map2.get(ch)+1);
                while(i<s.length() && isMatch(map1,map2)){
                    if(result.equals("") || result.length()>sb.length()) result = sb.toString();
                    if(map2.containsKey(s.charAt(i))) map2.put(s.charAt(i),map2.get(s.charAt(i))-1);
                    i++;
                    sb.deleteCharAt(0);
                }
                while(i<s.length() && !map2.containsKey(s.charAt(i))){
                    i++;
                    if(sb.length()>0) sb.deleteCharAt(0);
                }
            }
            j++;
        }
        return result;
    }

    public boolean isMatch(Map<Character,Integer> map1, Map<Character,Integer> map2){
        for(char ch : map1.keySet()){
            if(map2.get(ch)<map1.get(ch)) return false;
        }
        return true;
    }
}