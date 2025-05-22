class LRUCache {
    Node head;
    Node tail;
    int capacity;
    Map<Integer,Node> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        head.prev = null;
        tail.next = null;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node n = map.get(key);
        deleteNode(n);
        placeAfterHead(n);
        return n.value;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)){
            if(map.size()==capacity){
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
            }
            Node n = new Node(key,value);
            map.put(key,n);
            placeAfterHead(n);
        } 
        else{
            Node n = map.get(key);
            n.value = value;
            deleteNode(n);
            placeAfterHead(n);
        } 
    }

    public void placeAfterHead(Node n){
        Node nex = head.next;
        head.next = n;
        n.next = nex;
        nex.prev = n;
        n.prev = head;
    }

    public void deleteNode(Node n){
        Node prev = n.prev;
        Node nex = n.next;
        prev.next = nex;
        nex.prev = prev;
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


