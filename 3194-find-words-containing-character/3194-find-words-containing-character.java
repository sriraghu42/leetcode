class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<words.length; i++){
            char[] arr = words[i].toCharArray();
            for(int j=0; j<arr.length; j++){
                if(arr[j]==x){
                    ans.add(i);
                    break;
                }
            }
        }
        return ans;
    }
}