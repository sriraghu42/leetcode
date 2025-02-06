class Solution {
    public int tupleSameProduct(int[] nums) {
        int ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                int prod = nums[i]*nums[j];
                map.put(prod,map.getOrDefault(prod,0)+1);
            }
        }
        for(int value : map.values()){
            if(value>=2) ans+= value * (value-1)/(float) 2;
        }
        return ans*8;
    }
}