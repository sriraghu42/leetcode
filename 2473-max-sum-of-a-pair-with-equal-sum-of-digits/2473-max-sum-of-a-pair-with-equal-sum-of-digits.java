class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer,PriorityQueue<Integer>> map = new HashMap<>();
        for(int num : nums){
            int sum = sumOfDigits(num);
            map.putIfAbsent(sum,new PriorityQueue<>((a,b) -> a-b));
            PriorityQueue pq = map.get(sum);
            pq.offer(num);
            if(pq.size()>2) pq.poll();
        }

        int ans = -1;
        for(PriorityQueue<Integer> pq : map.values()){
            if(pq.size()>1){
                ans = Math.max(pq.poll()+pq.poll(),ans);
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