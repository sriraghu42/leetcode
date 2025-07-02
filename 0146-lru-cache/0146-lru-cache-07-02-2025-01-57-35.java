class LRUCache {
    int capacity;
    Node head;
    Node tail;
    Map<Integer,Node> map = new HashMap<>(); //cache
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }

    public void deleteNode(Node curr){
        Node prev = curr.prev;
        Node nxt = curr.next;
        prev.next = nxt;
        nxt.prev = prev;
    }

    public void addToLast(Node curr){
        Node prev = tail.prev;
        prev.next = curr;
        curr.prev = prev;
        curr.next = tail;
        tail.prev = curr;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node curr = map.get(key);
        deleteNode(curr);
        addToLast(curr);
        return curr.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node curr = map.get(key);
            curr.value = value;
            deleteNode(curr);
            addToLast(curr);
        }
        else{
            if(map.size()==capacity) removeLRU();
            Node curr = new Node(key,value);
            map.put(key,curr);
            addToLast(curr);
        }
    }

    public void removeLRU(){
        Node curr = head.next;
        deleteNode(curr);
        map.remove(curr.key);
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