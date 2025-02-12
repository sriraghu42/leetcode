class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int num : nums){
            int sum = sumOfDigits(num);
            map.putIfAbsent(sum,new ArrayList<>());
            map.get(sum).add(num);
        }

        int ans = -1;
        for(List<Integer> numList : map.values()){
            if(numList.size()>1){
                int firstMax = -1;
                int secondMax = -1;
                for(int num : numList){
                    if(num>firstMax){
                        secondMax = firstMax;
                        firstMax = num;
                    }
                    else if(num>secondMax){
                        secondMax = num;
                    }
                    else continue;
                }
                ans = Math.max(ans, firstMax+secondMax);
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