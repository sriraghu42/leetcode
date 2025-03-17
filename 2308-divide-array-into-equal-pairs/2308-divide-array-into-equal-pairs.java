class Solution {
    public boolean divideArray(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums) map.put(num,map.getOrDefault(num,0)+1);
        int size = 0;
        for(int value : map.values()){
            if(value%2!=0) return false;
            size+=value/2;
        }
        return size==nums.length/2;
    }
}