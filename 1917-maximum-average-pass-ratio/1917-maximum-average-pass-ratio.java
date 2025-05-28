class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b)-> Double.compare(b[2],a[2]));
        for(int[] cla : classes){
            double pass  = (double) cla[0];
            double total = (double) cla[1];
            double avg = ((pass+1)/(total+1))-(pass/total);
            pq.add(new double[] {pass,total,avg});
        }
        while(extraStudents>0){
            double[] top = pq.poll();
            top[0]++;
            top[1]++;
            top[2] = ((top[0]+1)/(top[1]+1))-(top[0]/top[1]);
            pq.add(top);
            extraStudents--;
        }
        double avg = 0;
        int len = pq.size();
        while(!pq.isEmpty()){
            double[] curr = pq.poll();
            avg+= (curr[0]/curr[1]);
        }
        return avg/len;
    }
}