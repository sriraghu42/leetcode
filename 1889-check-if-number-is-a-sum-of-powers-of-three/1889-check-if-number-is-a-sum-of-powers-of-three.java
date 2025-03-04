class Solution {
    public boolean checkPowersOfThree(int n) {
        List<Integer> threeList = new ArrayList<>();
        int val = 1;
        while(val<=n){
            threeList.add(val);
            val*=3;
        }
        int size = threeList.size();
        int sum = 0;
        for(int i=size-1; i>=0; i--){
            sum+=threeList.get(i);
            if(sum>n) sum-=threeList.get(i);
            else if(sum==n) return true;
        }
        return false;
    }

}