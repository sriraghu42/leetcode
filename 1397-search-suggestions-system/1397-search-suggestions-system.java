class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> ans = new ArrayList<>();
        for(int i=0; i<searchWord.length(); i++){
            List<String> list = new ArrayList<>();
            for(int j=0; j<products.length; j++){
                if(products[j].length()>i && products[j].substring(0,i+1).equals(searchWord.substring(0,i+1))) list.add(products[j]);
                if(list.size()==3) break;
            }
            ans.add(list);
        }
        return ans;
    }
}