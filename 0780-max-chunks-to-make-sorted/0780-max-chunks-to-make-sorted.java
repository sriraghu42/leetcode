class Solution {
    int counter = 0;
    int start = 0;
    public int maxChunksToSorted(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            list.add(arr[i]);
            if(check(list)){
                counter++;
                start+=list.size();
                list.clear();
            }
        }
        return counter;
        
    }

    public boolean check(List<Integer> list){
        list.sort(null);
        int count = 0;
        for(int i=start; i<start+list.size(); i++){
            if(list.get(count)!=i) return false;
            count++;
        }
        return true;
    }


}