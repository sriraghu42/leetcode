class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>();
        int len = products.length;
        int left = 0;
        int right = len-1;
        int searchPos = 0;
        Arrays.sort(products);
        while(searchPos<searchWord.length()){
            String searchString = searchWord.substring(0,searchPos+1);
            while(left<len && !products[left].startsWith(searchString)) left++;
            List<String> list = new ArrayList<>();
            int counter = 0;
            for(int i=left; i<=right; i++){
                if(!products[i].startsWith(searchString)){
                    right = i-1;
                    break;
                }
                else{
                    counter++;
                    list.add(products[i]);
                    if(counter==3) break;
                }
            }
            ans.add(list);
            searchPos++;
        }
        return ans;
    }
}