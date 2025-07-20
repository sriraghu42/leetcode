class MyHashMap {
    List<List<int[]>> list;
    public MyHashMap() {
        list = new ArrayList<>();
        for(int i=0; i<1000; i++) list.add(new ArrayList<>());
    }
    
    public int hashify(int n){
        return n%1000;
    }

    public void put(int key, int value) {
        int hash = hashify(key);
        List<int[]> temp = list.get(hash);
        if(temp.isEmpty()){
            temp.add(new int[] {key,value});
        }
        else{
            temp = list.get(hash);
            boolean keyFound = false;
            for(int i=0; i<temp.size(); i++){
                if(temp.get(i)[0]==key){
                    temp.get(i)[1] = value;
                    keyFound = true;
                    break;
                }
            }
            if(!keyFound){
                temp.add(new int[] {key,value});
            }
        }
    }
    
    public int get(int key) {
        int hash = hashify(key);
        boolean keyFound = false;
        List<int[]> temp = list.get(hash);
        for(int[] arr : temp){
            if(arr[0]==key) return arr[1];
        }
        return -1;
    }
    
    public void remove(int key) {
        int hash = hashify(key); 
        List<int[]> temp = list.get(hash);
        for(int i=0; i<temp.size(); i++){
            if(temp.get(i)[0]==key){
                temp.remove(i);
                break;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */