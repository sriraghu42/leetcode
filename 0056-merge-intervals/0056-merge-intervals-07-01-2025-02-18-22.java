class Solution {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if(len==1) return intervals;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> list = new ArrayList<>();
        int x = intervals[0][0];
        int y = intervals[0][1];
        for(int i=1; i<len; i++){
            int[] interval = intervals[i];
            if(interval[0]>y){
                list.add(new int[] {x,y});
                x = interval[0];
                y = interval[1];
            } 
            else{
                y = Math.max(y,interval[1]);
            }
        }
        list.add(new int[] {x,y});
        int[][] ans = new int[list.size()][2];
        for(int i=0; i<list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}