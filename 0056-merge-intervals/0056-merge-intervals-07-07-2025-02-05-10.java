class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int len = intervals.length;
        int[] ref = intervals[0];
        List<int[]> list = new ArrayList<>();
        for(int i=1; i<len; i++){
            int[] interval = intervals[i];
            if(interval[0]>ref[1]){
                list.add(ref);
                ref = interval;
            }
            else{
                ref[1] = Math.max(ref[1],interval[1]);
            }
        }
        list.add(ref);
        int[][] ans = new int[list.size()][2];
        int counter = 0;
        for(int[] arr : list) {
            ans[counter] = arr;
            counter++;
        }
        return ans;
    }
}