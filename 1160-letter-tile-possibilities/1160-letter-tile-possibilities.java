class Solution {
    int counter = 0;
    public int numTilePossibilities(String tiles) {
        char[] arr = tiles.toCharArray();
        Arrays.sort(arr);
        boolean[] visited = new boolean[tiles.length()];
        backtrack(arr,visited);
        return counter;
    }

    public void backtrack(char[] arr, boolean[] visited){
        for(int i=0; i<arr.length; i++){
            if(!visited[i]){
                if(i>0 && arr[i]==arr[i-1] && !visited[i-1]) continue;
                counter++;
                visited[i] = true;
                backtrack(arr,visited);
                visited[i] = false;
            }
        }
    }
}