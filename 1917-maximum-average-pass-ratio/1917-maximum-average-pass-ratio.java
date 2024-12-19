class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b)->{
            return Double.compare(b[0],a[0]);
        });
        for(int[] clazz : classes){
            double increase = ((clazz[0]+1)/(double) (clazz[1]+1)) - ((clazz[0]/(double) clazz[1]));
            pq.add(new double[] {increase,clazz[0],clazz[1]});
        }
        while(extraStudents>0){
            double[] clazz = pq.poll();
            clazz[1]++;
            clazz[2]++;
            double increase = ((clazz[1]+1)/(double) (clazz[2]+1)) - ((clazz[1]/(double) clazz[2]));
            pq.add(new double[] {increase,clazz[1],clazz[2]});
            extraStudents--;
        }
        double sum = 0;
        while(!pq.isEmpty()){
            double[] clazz = pq.poll();
            sum+= (clazz[1]/(double) clazz[2]);
        }
        return sum/classes.length;
    }
}