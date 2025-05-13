class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int len = hand.length;
        if(len%groupSize!=0) return false;
        int groups = len/groupSize;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int num : hand) map.put(num,map.getOrDefault(num,0)+1);
        while(!map.isEmpty()){
            int small = map.firstKey();
            for(int i=0; i<groupSize; i++){
                if(!map.containsKey(small)) return false;
                map.put(small,map.get(small)-1);
                if(map.get(small)==0) map.remove(small);
                small++;
            }
        }
        return true;
    }
}

