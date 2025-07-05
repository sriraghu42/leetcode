class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int len = words.length;
        int i=0;
        int j=0;
        int charCount = 0;
        List<String> ans = new ArrayList<>();
        while(j<len){
            String jWord = words[j];
            if(charCount+(i==j?0:1)+jWord.length()>maxWidth){
                addLine(words,i,j,ans,charCount,maxWidth);
                i=j;
                charCount = 0;
            }
            charCount+=jWord.length()+(i==j?0:1);
            j++;
        }
        addLastLine(words,i,j,ans,charCount,maxWidth);
        return ans;
    }

    public void addLastLine(String[] words,int i,int j,List<String> ans,int charCount,int maxWidth){
        StringBuilder sb = new StringBuilder();
        while(i<j){
            sb.append(words[i]);
            if(i!=j-1) sb.append(" ");
            i++;
        }
        int size = sb.length();
        for(int k = size; k<maxWidth; k++) sb.append(" ");
        ans.add(sb.toString());
    }


    public void addLine(String[] words,int i,int j,List<String> ans,int charCount,int maxWidth){
        StringBuilder sb = new StringBuilder();
        if(i==j-1){
            sb.append(words[i]);
            int size = sb.length();
            for(int k = size; k<maxWidth; k++) sb.append(" ");
        }
        else{
            int extraSpaces = (maxWidth-charCount)/(j-i-1);
            int oddSpaces = (maxWidth-charCount)%(j-i-1);
            System.out.println("charCOunt: "+charCount);
            System.out.println("extraSpaces: "+extraSpaces);
            System.out.println("oddSpaces: "+oddSpaces);
            while(i<j-1){
                sb.append(words[i]).append(" ");
                for(int k=0; k<extraSpaces; k++) sb.append(" ");
                if(oddSpaces>0){
                    sb.append(" ");
                    oddSpaces--;
                } 
                i++;
            }
            sb.append(words[i]);
        }
        ans.add(sb.toString());
    }
}