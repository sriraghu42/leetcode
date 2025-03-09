class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        long[] ans = new long[nums1.length];
        List<Triple> list = new ArrayList<>();
        for(int i=0; i<nums1.length; i++){
            list.add(new Triple(i,nums1[i],nums2[i]));
        }
        list.sort((a,b) -> a.i - b.i);
        //for(Triple triple : list) System.out.println(triple.index + " : " + triple.i +" : " + triple.j);
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        long sum = 0;
        for(int m=0; m<list.size(); m++){
            Triple triple = list.get(m);
            if(m==0) ;
            else if(triple.i>list.get(m-1).i){
                ans[triple.index] = sum;
            }
            else ans[triple.index] = ans[list.get(m-1).index];
            pq.add(triple.j);
            sum+=triple.j;
            if(pq.size()>k) sum-=pq.poll();
            
        }
        return ans;
    }
}

class Triple{
    int index;
    int i;
    int j;
    Triple(int index, int i, int j){
        this.index = index;
        this.i = i;
        this.j = j;
    }
}
