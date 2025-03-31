class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<double[]> list = new ArrayList<>();
        for(int i=0; i<position.length; i++){
            double value = (target - position[i])/ (double) speed[i];
            list.add(new double[] {position[i],value});
        }
        list.sort((a,b)-> Double.compare(b[0],a[0]));
        double compValue = -1;
        int ans = 0;
        for(double[] entry : list){
            if(entry[1]<=compValue) continue;
            ans++;
            compValue = entry[1];
        }
        return ans;
    }
}

/*
                    |12|
                10                 
            8
0
        5
    3

10 -> 2 -> 1s
8 -> 4 -> 1s
0 -> 1 -> 12s
5-> 1 -> 7s
3-> 3 -> 3s

4 -> 1 -> 96s
2 -> 2 -> 49s
0 -> 4 -> 25s

store it in map (position, time)
sort by position decreasing order
iterate through list and run logic
*/


