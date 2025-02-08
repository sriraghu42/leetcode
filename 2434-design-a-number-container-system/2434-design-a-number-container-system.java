class NumberContainers {
    Map<Integer,Integer> indexMap = new HashMap<>();
    Map<Integer,TreeSet> numMap = new HashMap<>();
    public NumberContainers() {
        
    }
    
    public void change(int index, int number) {
        TreeSet<Integer> indexSet = new TreeSet<>();
        if(numMap.containsKey(number)){
            indexSet = numMap.get(number);
        }
        indexSet.add(index);
        numMap.put(number,indexSet);
        if(indexMap.containsKey(index)){
            int oldNumber = indexMap.get(index);
            if(oldNumber!=number){
                TreeSet<Integer> oldNumIndexSet = numMap.get(oldNumber);
                oldNumIndexSet.remove(index);
                if(oldNumIndexSet.isEmpty()) numMap.remove(oldNumber);
                else numMap.put(oldNumber,oldNumIndexSet);
            }
        }
        indexMap.put(index,number);
    }
    
    public int find(int number) {
        if(numMap.containsKey(number)){
            TreeSet<Integer> indexSet = numMap.get(number);
            return indexSet.first();
        }
        return -1;
    }
}
 
/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */