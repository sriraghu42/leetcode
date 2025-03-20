class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,Integer> map = new HashMap<>();
        int counter = 0;
        List<List<String>> ans = new ArrayList<>();
        for(String str : strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortedStr = new String(arr);
            if(map.containsKey(sortedStr)){
                ans.get(map.get(sortedStr)).add(str);
            }
            else{
                map.put(sortedStr,counter);
                counter++;
                List<String> list = new ArrayList<>();
                list.add(str);
                ans.add(list);
            }
        }
        return ans;
    }
}