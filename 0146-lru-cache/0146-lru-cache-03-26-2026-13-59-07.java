class LRUCache {
    int capacity;
    Node head;
    Node tail;
    Map<Integer,Node> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node currNode = map.get(key);
            removeFromCurr(currNode);
            addToFirst(currNode);
            return map.get(key).value;
        } 
        return -1;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)){
            if(map.size()==capacity){
                removeLRU();
            }
            Node currNode = new Node(key,value);
            map.put(key,currNode);
            addToFirst(currNode);
        }
        else{
            Node currNode = map.get(key);
            currNode.value = value;
            removeFromCurr(currNode);
            addToFirst(currNode);
        }
    }

    public void addToFirst(Node node){
        Node afterNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = afterNode;
        afterNode.prev = node;
    }

    public void removeFromCurr(Node node){
        Node beforeNode = node.prev;
        Node afterNode = node.next;
        beforeNode.next = afterNode;
        afterNode.prev = beforeNode;
    }

    public void removeLRU(){
        Node currNode = tail.prev;
        Node beforeNode = currNode.prev;
        beforeNode.next = tail;
        tail.prev = beforeNode;
        map.remove(currNode.key);
    }
}

class Node{
    int key;
    int value;
    Node prev;
    Node next;
    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */