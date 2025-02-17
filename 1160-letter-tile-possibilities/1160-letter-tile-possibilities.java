class Solution {
    int count = 0;
    public int numTilePossibilities(String tiles) {
        char[] charArr = tiles.toCharArray();
        Arrays.sort(charArr);
        int len = charArr.length;
        boolean[] visited = new boolean[len];
        helperRec(charArr,visited,len);
        return count;
    }

    public void helperRec(char[] charArr, boolean[] visited, int len){
        for(int i=0; i<len; i++){
            if(!visited[i]){
                if(i>0 && charArr[i]==charArr[i-1] && !visited[i-1]) continue;
                visited[i] = true;
                count++;
                helperRec(charArr,visited,len);
                visited[i] = false;
            }
        }
    }
}