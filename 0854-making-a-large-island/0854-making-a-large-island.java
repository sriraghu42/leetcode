class Solution {
    int ans = 0;
    int[][] directions = new int[][] {{-1,0},{1,0},{0,1},{0,-1}};
    public int largestIsland(int[][] grid) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = grid.length;
        int counter = 2;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    int[] count = new int[1];
                    dfs(grid,i,j,n,count,counter);
                    map.put(counter,count[0]);
                    counter++;
                } 
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==0){
                    Set<Integer> set = new HashSet<>();
                    int localAns = 1;
                    for(int[] dir : directions){
                        int x = i+dir[0];
                        int y = j+dir[1];
                        if(x<0 || x>=n || y<0 || y>=n || grid[x][y]==0) continue;
                        if(!set.contains(grid[x][y])) localAns+=map.get(grid[x][y]);
                        //System.out.println(localAns);
                        set.add(grid[x][y]);
                    }
                    ans = Math.max(localAns,ans);
                }
            }
        }
        return ans==0?n*n:ans;
    }

    public void dfs(int[][] grid, int i, int j, int n, int[] count, int counter){
        count[0]++;
        grid[i][j] = counter;
        for(int[] dir : directions){
            int x = i+dir[0];
            int y = j+dir[1];
            if(x<0 || x>=n || y<0 || y>=n || grid[x][y]!=1) continue;
            dfs(grid,x,y,n,count,counter);
        }
    }
}