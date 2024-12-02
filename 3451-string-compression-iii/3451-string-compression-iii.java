class Solution {
    public String compressedString(String word) {
        int counter = 1;
        int len = word.length();
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<len; i++){
            if(word.charAt(i)==word.charAt(i-1)){
                counter++;
                if(counter>9){
                    sb.append(counter-1);
                    sb.append(word.charAt(i));
                    counter = 1;
                }
            }
            else if(word.charAt(i)!=word.charAt(i-1)){
                sb.append(counter);
                sb.append(word.charAt(i-1));
                counter = 1;
            }
        }
        sb.append(counter);
        sb.append(word.charAt(word.length()-1));
        return sb.toString();
    }
}