class KthLargest {
    List<Integer> list = new ArrayList<>();
    int nth = 0;
    public KthLargest(int k, int[] nums) {
        nth = k;
        for(int num : nums) list.add(num);
    }
    
    public int add(int val) {
        list.add(val);
        list.sort((a,b) -> b-a);
        return list.get(nth-1);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */