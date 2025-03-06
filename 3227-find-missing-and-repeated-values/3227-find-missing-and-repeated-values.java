class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int rows = grid.length;
        int size = rows * rows;
        int[] nums = new int[size+1];
        for(int i=0; i<rows; i++){
            for(int j=0; j<rows; j++){
                nums[grid[i][j]]++;
            }
        }
        int[] ans = new int[2];
        for(int i=1; i<=size; i++){
            if(nums[i]==0) ans[1] = i;
            else if(nums[i]>1) ans[0] = i;
            else continue;
        }
        return ans;
    }
}