class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String,Integer> map = new HashMap<>();
        boolean flip = false;
        for(int[] mat : matrix){
            StringBuilder sb = new StringBuilder();
            if(mat[0]==1) flip = true;
            else flip = false;
            for(int i=0; i<mat.length; i++){
                if(flip) sb.append(1-mat[i]);
                else sb.append(mat[i]);
            }
            String key = sb.toString();
            map.put(key,map.getOrDefault(key,0)+1);
        }
        int ans = 0;
        for(int value : map.values()){
            ans = Math.max(ans,value);
        }
        return ans;
    }
}