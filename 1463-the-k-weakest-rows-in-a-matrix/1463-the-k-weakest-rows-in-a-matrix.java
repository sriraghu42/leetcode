class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<mat.length; i++){
            int[] row = mat[i];
            int counter = 0;
            for(int num : row){
                if(num!=1) break;
                counter++;
            }
            map.put(i,counter);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((entry1,entry2) -> {
            int compValue = entry1.getValue().compareTo(entry2.getValue());
            if(compValue!=0) return compValue;
            return entry1.getKey().compareTo(entry2.getKey());
        });

        int[] ans = new int[k];
        for(int i=0; i<k; i++){
            ans[i] = list.get(i).getKey();
        }
        return ans;
    }
}