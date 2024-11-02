class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] sentArray = sentence.split(" ");
        if(sentArray[0].charAt(0)==sentArray[sentArray.length-1].charAt(sentArray[sentArray.length-1].length()-1)){
            int i = 0;
            while(i<sentArray.length-1){
                if(sentArray[i].charAt(sentArray[i].length()-1)!=sentArray[i+1].charAt(0)) return false;
                i++;
            }
            return true;
        }
        return false;
    }
}