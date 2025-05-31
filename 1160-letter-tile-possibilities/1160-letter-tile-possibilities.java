class Solution {
    int ans=-1;
    public int numTilePossibilities(String tiles) {
        int len = tiles.length();
        char[] tilesArr = tiles.toCharArray();
        Arrays.sort(tilesArr);
        boolean[] visited = new boolean[len];
        search(tilesArr,len,visited);
        return ans;
    }

    public void search(char[] arr, int len, boolean[] visited){
        ans++;
        for(int i=0; i<len; i++){
            if(visited[i] || (i>0 && arr[i]==arr[i-1] && !visited[i-1])) continue;
            visited[i] = true;
            search(arr,len,visited);
            visited[i] = false;
        }
    }
}