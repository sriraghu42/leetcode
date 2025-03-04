class Solution {
    boolean found = false;
    int sum = 0;
    public boolean checkPowersOfThree(int n) {
        List<Integer> threeList = new ArrayList<>();
        int val = 1;
        while(val<=n){
            threeList.add(val);
            val*=3;
        }
        int size = threeList.size();
        helperRec(n,threeList,size,0);
        return found;
    }

    public void helperRec(int n, List<Integer> threeList,int size, int index){
        if(sum==n){
            found = true;
            return;
        }
        if(index>=size) return;
        for(int i=index; i<size; i++){
            if(!found) helperRec(n,threeList,size,i+1);
            else return;
            sum+=threeList.get(i);
            if(!found) helperRec(n,threeList,size,i+1);
            else return;
            sum-=threeList.get(i);
        }
    }
}