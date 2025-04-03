class KthLargest {
    List<Integer> list = new ArrayList<>();
    int nth = 0;
    public KthLargest(int k, int[] nums) {
        nth = k;
        for(int num : nums) list.add(num);
        list.sort(null);
    }
    
    public int add(int val) {
        int i = 0;
        int j = list.size()-1;
        while(i<=j){
            int k = i+(j-i)/2;
            if(list.get(k)>=val) j--;
            else i++;
        }
        list.add(i,val);
        return list.get(list.size()-nth);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */