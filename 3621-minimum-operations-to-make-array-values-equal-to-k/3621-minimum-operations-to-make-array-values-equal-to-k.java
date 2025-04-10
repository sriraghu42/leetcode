class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums) set.add(num);
        List<Integer> list = new ArrayList<>(set);
        int i = 0;
        int j = list.size()-1;
        list.sort(null);
        for(int num : list){
            if(num<k) return -1;
        }
        while(i<=j){
            int m = i+(j-i)/2;
            System.out.println(m);
            if(list.get(m)==k) return list.size()-i-1;
            else if(list.get(m)>k) j=m-1;
            else i=m+1;
        }
        return list.size()-i;
    }
}