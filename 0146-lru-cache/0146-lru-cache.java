class LRUCache {
    Map<Integer,Node> map;
    Node head;
    Node tail;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node n = map.get(key);
        delete(n);
        addToFirst(n);
        return n.value;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)){
            if(map.size()==capacity){
                Node rem = tail.prev;
                delete(rem);
                map.remove(rem.key);
            }
            Node n = new Node(key,value);
            map.put(key,n);
            addToFirst(n);
        }
        else{
            Node n = map.get(key);
            n.value = value;
            delete(n);
            addToFirst(n);
        }
    }

    public void delete(Node n){
        Node pre = n.prev;
        Node nex = n.next;
        pre.next = nex;
        nex.prev = pre;
    }

    public void addToFirst(Node n){
        Node nex = head.next;
        head.next = n;
        n.prev = head;
        n.next = nex;
        nex.prev = n;
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