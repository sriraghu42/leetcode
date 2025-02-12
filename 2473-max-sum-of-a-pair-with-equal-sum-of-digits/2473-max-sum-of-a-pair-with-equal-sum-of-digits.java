class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int num : nums){
            int sum = sumOfDigits(num);
            if(map.containsKey(sum)){
                List<Integer> list = map.get(sum);
                list.add(num);
                map.put(sum,list);
            }
            else map.put(sum, new ArrayList<>(List.of(num)));
        }

        int ans = -1;
        for(List<Integer> numList : map.values()){
            if(numList.size()>1){
                numList.sort((a,b) -> b-a);
                ans = Math.max(ans, numList.get(0)+numList.get(1));
            }
        }
        return ans;
    }

    public int sumOfDigits(int num){
        int sum = 0;
        while(num!=0){
            sum+=num%10;
            num = num/10;
        }
        return sum;
    }
}