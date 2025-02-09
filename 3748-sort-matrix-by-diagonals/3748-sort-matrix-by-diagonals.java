class Solution {
    public int[][] sortMatrix(int[][] grid) {
        List<Integer> list = new ArrayList<>();
        int n = grid.length;
        for(int i=0; i<n; i++){
            list.add(grid[i][i]);
        }
        list.sort((a,b) -> b-a);
        for(int i=0; i<n; i++){
            grid[i][i] = list.get(i);
        }
        list.clear();
        int rowP = 1;
        List<Integer> list2 = new ArrayList<>();
        while(rowP<n){
            for(int i=rowP; i<n; i++){
                list.add(grid[i][i-rowP]);
                list2.add(grid[i-rowP][i]);
            }
            list.sort((a,b)->b-a);
            list2.sort((a,b)->a-b);
            int counter = 0;
            for(int i=rowP; i<n; i++){
                grid[i][i-rowP] = list.get(counter);
                grid[i-rowP][i] = list2.get(counter);
                counter++;
            }
            list.clear();
            list2.clear();
            rowP++;
        }
        return grid;
    }
}