class Solution {
    Set<String> set = new HashSet<>();
    public int numTilePossibilities(String tiles) {
        char[] charArr = tiles.toCharArray();
        Arrays.sort(charArr);
        StringBuilder sb = new StringBuilder();
        int len = charArr.length;
        boolean[] visited = new boolean[len];
        helperRec(charArr,visited,sb,len);
        return set.size();
    }

    public void helperRec(char[] charArr, boolean[] visited, StringBuilder chosen, int len){
        if(chosen.length()==len) return;
        for(int i=0; i<len; i++){
            if(i>0 && charArr[i]==charArr[i-1] && !visited[i-1]) continue;
            if(!visited[i]){
                visited[i] = true;
                char ch = charArr[i];
                chosen.append(ch);
                String temp = chosen.toString();
                if(!set.contains(temp)){
                    set.add(temp);
                    helperRec(charArr,visited,chosen,len);
                } 
                visited[i] = false;
                chosen.deleteCharAt(chosen.length()-1);
            }
        }
    }
}