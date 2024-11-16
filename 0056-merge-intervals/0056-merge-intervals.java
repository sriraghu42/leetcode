class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        int[] curr = intervals[0];
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0]>curr[1]){
                list.add(curr);
                curr = intervals[i];
            }
            else{
                curr[1]=(curr[1]>=intervals[i][1]?curr[1]:intervals[i][1]);
            }
        }
        list.add(curr);
        int[][] ans = new int[list.size()][2];
        for(int i=0; i<list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}