class Solution {
    public int longestPalindrome(String[] words) {
        Map<String,Integer> map = new HashMap<>();
        for(String word :words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        boolean same = false;
        int ans = 0;
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            String word = entry.getKey();
            int value = entry.getValue();
            if(word.charAt(0)==word.charAt(1)){
                ans+=(value/2)*4;
                if(value%2==1) same = true;
            }
            else{
                String reverse = new StringBuilder().append(word.charAt(1)).append(word.charAt(0)).toString();
                if(map.containsKey(reverse)){
                    int revValue = map.get(reverse);
                    ans+= (Math.min(value,revValue) * 2);
                }
            }
                       
        }
        return same?ans+2:ans;
    }
}