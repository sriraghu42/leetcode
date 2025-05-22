class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int len = words.length;
        int i = 0;
        List<String> ans = new ArrayList<>();
        int j = 0;
        while(i<len){
            int totCount = 0;
            int letterCount = 0;
            while(j<len){
                if(totCount+words[j].length()>maxWidth) break;
                totCount+=words[j].length()+1;
                letterCount+=words[j].length();
                j++;
            }
            StringBuilder sb = new StringBuilder();
            int totSpaces = maxWidth - letterCount;
            if(j==len || j==i+1){
                for(int k=i; k<j; k++){
                    sb.append(words[k]).append(" ");
                    totSpaces--;
                }
                sb.setLength(sb.length()-1);
                totSpaces++;
                while(totSpaces>0){
                    sb.append(" ");
                    totSpaces--;
                }
            }
            else{
                int perSpace = totSpaces/(j-i-1);
                int extraSpace = totSpaces%(j-i-1);
                for(int k=i; k<j; k++){
                    sb.append(words[k]);
                    if(k!=j-1) for(int l=0; l<perSpace; l++) sb.append(" ");
                    if(extraSpace>0){
                        sb.append(" ");
                        extraSpace--;
                    } 
                }
            }
            System.out.println(sb.length());
            ans.add(sb.toString());
            i=j;
        }
        return ans;
    }
}
/*
1. except last line, evenly distribute. spaces left>=right;
2. last line - left justified
3. odd spaces - calculate extar spaces and give to the left
*/