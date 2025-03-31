class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer,Double> map = new HashMap<>();
        for(int i=0; i<position.length; i++){
            double value = (target - position[i])/ (double) speed[i];
            map.put(position[i],value);
        }
        List<Map.Entry<Integer,Double>> list = new ArrayList<>(map.entrySet());
        list.sort((a,b)-> b.getKey()-a.getKey());
        double compValue = list.get(0).getValue();
        int ans = 1;
        for(Map.Entry<Integer,Double> entry : list){
            if(entry.getValue()<=compValue) continue;
            ans++;
            compValue = entry.getValue();
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


