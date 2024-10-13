class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for(String str : strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            if(map.containsKey(sorted)){
                res.get(map.get(sorted)).add(str);
            }
            else{
                List<String> list = new ArrayList<>();
                list.add(str);
                res.add(list);
                map.put(sorted,res.size()-1);
            }
        }
        return res;
    }
}