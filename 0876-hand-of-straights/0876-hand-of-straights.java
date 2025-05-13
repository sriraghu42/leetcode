class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int len = hand.length;
        if(len%groupSize!=0) return false;
        int groups = len/groupSize;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : hand) map.put(num,map.getOrDefault(num,0)+1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.add(new int[] {entry.getKey(),entry.getValue()});
        }
        while(groups>0){
            groups--;
            int[][] groupHand = new int[groupSize][2];
            for(int i=0; i<groupSize; i++){
                if(pq.isEmpty()) return false;
                int[] temp = pq.poll();
                groupHand[i][0]=temp[0];
                groupHand[i][1]=temp[1];
            }
            for(int i=0; i<groupSize; i++){
                if(groupHand[i][1]>1) pq.add(new int[] {groupHand[i][0],groupHand[i][1]-1});
                if(i>0 && groupHand[i][0]!=groupHand[i-1][0]+1) return false;
            }
        }
        return true;
    }
}

