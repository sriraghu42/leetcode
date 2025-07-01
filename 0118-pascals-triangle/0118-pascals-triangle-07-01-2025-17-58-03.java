class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        ans.add(list1);
        if(numRows==1) return ans;
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(1);
        ans.add(list2);
        if(numRows==2) return ans;
        for(int i=3; i<=numRows; i++){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for(int j=1; j<i-1; j++){
                list.add(ans.get(i-2).get(j-1)+ans.get(i-2).get(j));
            }
            list.add(1);
            ans.add(list);
        }
        return ans;
    }
}
