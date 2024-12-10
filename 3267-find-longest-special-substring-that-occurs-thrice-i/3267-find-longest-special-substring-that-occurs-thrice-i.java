class Solution {
    public int maximumLength(String s) {
        HashMap<String,Integer> map = new HashMap<>();
        int size = s.length();
        for(int i=0; i<size; i++){
            for(int j=i+1; j<size+1; j++){
                String str = s.substring(i,j);
                map.put(str,map.getOrDefault(str,0)+1);
                if(j<size && s.charAt(j)!=s.charAt(i)) break;
            }
        }

        int ans = -1;
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            System.out.println("Key : "+entry.getKey()+" , Value : "+entry.getValue());
            if(entry.getValue()>=3) ans = Math.max(ans,entry.getKey().length());
        }
        return ans;
    }
}