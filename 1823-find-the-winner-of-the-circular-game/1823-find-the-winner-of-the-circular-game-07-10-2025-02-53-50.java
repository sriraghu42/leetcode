class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++) list.add(i);
        int i=0;
        while(list.size()>1){
            //System.out.println("i before:"+i);
            //System.out.println("size:"+list.size());
            i = (i+k-1)%list.size();
            //System.out.println("i after:"+i);
            list.remove(i);
        }
        return list.get(0);
    }
}


