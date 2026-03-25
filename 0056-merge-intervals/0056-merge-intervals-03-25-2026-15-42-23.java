class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int left = intervals[0][0];
        int right = intervals[0][1];
        int len = intervals.length;
        List<int[]> list = new ArrayList<>();
        for(int i=1; i<len; i++){
            int[] curr = intervals[i];
            if(curr[0]>right){
                list.add(new int[] {left,right});
                left = curr[0];
                right = curr[1];
            }
            else{
                if(curr[1]>right) right = curr[1];
            }
        }
        list.add(new int[] {left,right});
        int size = list.size();
        int[][] ans = new int[size][2];
        for(int i=0; i<size; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}