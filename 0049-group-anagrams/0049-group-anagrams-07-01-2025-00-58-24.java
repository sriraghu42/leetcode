class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortedStr = new String(arr);
            if(map.containsKey(sortedStr)) map.get(sortedStr).add(str);
            else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sortedStr,list);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(List<String> list : map.values()){
            ans.add(list);
        }
        return ans;
    }
}