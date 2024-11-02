class Solution {
    public String makeFancyString(String s) {
        int counter = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        int i = 1;
        while(i<s.length()){
            if(s.charAt(i)==s.charAt(i-1)){
                counter++;
                if(counter<3) sb.append(s.charAt(i)); 

            }
            else{
                sb.append(s.charAt(i));
                counter=1;
            }
            i++;
        }
    return sb.toString();
    }
}