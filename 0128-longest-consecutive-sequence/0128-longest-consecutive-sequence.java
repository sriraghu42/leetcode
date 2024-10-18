class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        int counter = 0;
        int max = 0;
        for(int num : nums){
            if(set.contains(num-1)) continue;
            else{
                while(set.contains(num)){
                    counter++;
                    num+=1;
                }
                max = Math.max(counter,max);
                counter = 0;
            }
        }
        return max;
    }
}