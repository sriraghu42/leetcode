class Solution {
    Set<String> set = new HashSet<>();
    public int numTilePossibilities(String tiles) {
        StringBuilder sb = new StringBuilder();
        int len = tiles.length();
        boolean[] visited = new boolean[len];
        helperRec(tiles,visited,sb,len);
        return set.size(); //set.length();
    }

    public void helperRec(String tiles, boolean[] visited, StringBuilder chosen, int len){
        if(chosen.length()==len) return;
        for(int i=0; i<len; i++){
            if(!visited[i]){
                visited[i] = true;
                char ch = tiles.charAt(i);
                chosen.append(ch);
                String temp = chosen.toString();
                if(!set.contains(temp)){
                    set.add(temp);
                    helperRec(tiles,visited,chosen,len);
                } 
                visited[i] = false;
                chosen.deleteCharAt(chosen.length()-1);
            }
        }
    }
}