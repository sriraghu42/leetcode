class Solution {
    public String minWindow(String s, String t) {
        Set<Character> set = new HashSet<>();
        String result = "";
        int[] arr = new int[128];
        int count = t.length();
        for(char ch : t.toCharArray()){
            arr[ch]++;
            set.add(ch);
        } 
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while(j<s.length()){
            char ch = s.charAt(j);
            sb.append(ch);
            if(set.contains(ch)){
                arr[ch]--;
                //System.out.println(ch + " : " + arr[ch]);
                if(arr[ch]>=0) count--;
                while(count==0){
                    //System.out.println(sb.toString());
                    //System.out.println("i : "+i);
                    if(result.equals("") || result.length()>sb.length()) result = sb.toString();
                    if(set.contains(s.charAt(i))){
                        arr[s.charAt(i)]++;
                        if(arr[s.charAt(i)] > 0) count++;
                    }
                    sb.deleteCharAt(0);
                    i++;
                } 
            }
            j++;
        }
        return result;
    }
}