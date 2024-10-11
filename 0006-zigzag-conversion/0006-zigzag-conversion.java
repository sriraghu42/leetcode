class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        List<List<Character>> list = new ArrayList<>();
        for(int i=0; i<numRows; i++){
            list.add(new ArrayList<>());
        }
        int k = 0;
        boolean topToBottom = true;
        int i=0;
        while(k<s.length()){
            char ch = s.charAt(k);
            list.get(i).add(ch);
            if(i==0){
                topToBottom = true;
                i++;
            } 
            else if(i==numRows-1) {
                i--;
                topToBottom = false;
            }
            else if(topToBottom) i++;
            else i--;
            k++;
        }
        StringBuilder sb = new StringBuilder();
        for(List<Character> l : list){
            for(char ch : l){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}