class Solution {
    int[][] directions = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        for(int i=0; i<heights.length; i++){
            for(int j=0; j<heights[0].length; j++){
                boolean[] ocean = new boolean[2];
                boolean[][] visited = new boolean[heights.length][heights[0].length];
                dfs(heights,i,j,ocean,visited);
                if(ocean[0] && ocean[1]) ans.add(Arrays.asList(i,j));
            }
        }
        return ans;
    }

    public void dfs(int[][] heights, int i, int j, boolean[] ocean, boolean[][] visited){
        visited[i][j] = true;
        if(ocean[0] && ocean[1]) return;
        for(int[] dir : directions){
            int a = i + dir[0];
            int b = j + dir[1];
            if(a==-1 || b==-1){
                ocean[0] = true;
                continue;
            } 
            if(a==heights.length || b==heights[0].length){
                ocean[1] = true;
                continue;
            }
            if(visited[a][b]) continue;
            if(heights[a][b]<=heights[i][j]) dfs(heights,a,b,ocean,visited);
        }
    }
}