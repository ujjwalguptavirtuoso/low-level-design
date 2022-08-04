package lru;

import java.util.HashMap;
import java.util.Map;

class Node{
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {

    Map<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
    }

    void detachNode(Node node){
        if(node == null){
            return;
        }
        if(node.equals(head)){
            head = head.next;
            if(head!= null){
                head.prev = null;
            }
        }
        else if(node.equals(tail)){
            tail = tail.prev;
            if(tail!=null){
                tail.next = null;
            }
        }
        else{
            System.out.println(node.key);
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
    }

    void addNodeAtLast(Node node){
        if(tail == null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            node.prev = tail;
            node.next = null;
            tail = node;
        }

        if(head == null){
            head = tail;
        }
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node temp =  map.get(key);
            detachNode(temp);
            addNodeAtLast(temp);
            return temp.val;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node temp = map.get(key);
            temp.val = value;
            map.put(key, temp);
            detachNode(temp);
            addNodeAtLast(temp);
        }else{
            if(capacity == map.size()){
                map.remove(head.key);
                detachNode(head);
            }
            Node temp = new Node(key, value);
            map.put(key, temp);
            addNodeAtLast(temp);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
        cache.put(2,1);
        cache.get(2);
        cache.put(3,2);
        cache.get(2);
        cache.get(3);
    }
}
