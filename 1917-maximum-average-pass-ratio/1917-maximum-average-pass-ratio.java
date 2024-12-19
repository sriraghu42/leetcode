class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            double newA = (a[0]+1)/(double) (a[1]+1);
            double increaseInA = newA - (a[0]/(double) a[1]);
            double newB = (b[0]+1)/(double) (b[1]+1);
            double increaseInB = newB - (b[0]/(double) b[1]);
            return Double.compare(increaseInB,increaseInA);
        });
        for(int[] clazz : classes){
            pq.add(clazz);
        }
        while(extraStudents>0){
            int[] clazz = pq.poll();
            pq.add(new int[] {clazz[0]+1,clazz[1]+1});
            extraStudents--;
        }
        int size = pq.size();
        double sum = 0;
        while(!pq.isEmpty()){
            int[] clazz = pq.poll();
            sum+= (clazz[0]/(double) clazz[1]);
        }
        return sum/(double) size;
    }
}