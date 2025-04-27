class Solution {
    public int countLargestGroup(int n) {
        int max = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=1; i<=n; i++){
            int sum = count(i);
            map.put(sum,map.getOrDefault(sum,0)+1);
            max = Math.max(max,map.get(sum));
        }
        int ans = 0;
        for(int val : map.values()){
            if(val == max) ans++;
        }
        return ans;
    }

    public int count(int n){
        int sum = 0;
        while(n!=0){
            sum+=n%10;
            n=n/10;
        }
        return sum;
    }
}